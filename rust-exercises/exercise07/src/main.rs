// async fn compiles into a state machine.
// Each .await is a yield point.
// Tokio drives these state machines on a thread pool.
// tokio::spawn requires Send + 'static so tasks can be moved between threads.

use futures::future::join_all;
use std::sync::Arc;
use std::time::{Duration, Instant};
use tokio::sync::Semaphore;
use tokio::time::timeout;

async fn fetch_url(url: &str) -> Result<String, reqwest::Error> {
    let response = reqwest::get(url).await?;
    response.text().await
}

#[tokio::main]
async fn main() {
    let urls = [
        "https://httpbin.org/get",
        "https://httpbin.org/delay/1",
        "https://httpbin.org/delay/2",
        "https://httpbin.org/status/404",
        "https://httpbin.org/status/200",
    ];

    let sem = Arc::new(Semaphore::new(5)); // max 5 concurrent requests
    let start = Instant::now();

    // Spawn one task per URL
    let handles: Vec<_> = urls
        .iter()
        .map(|url| {
            let url = url.to_string();
            let sem = Arc::clone(&sem);
            tokio::spawn(async move {
                // Acquire a permit — dropped at end of block
                let _permit = sem.acquire().await.unwrap();
                // 3-second timeout per request
                let t = Instant::now();
                let result = timeout(Duration::from_secs(3), fetch_url(&url)).await;
                let elapsed = t.elapsed();
                (url, result, elapsed)
            })
        })
        .collect();

    let results = join_all(handles).await;

    let (mut ok, mut err) = (0usize, 0usize);
    let mut total_ms = 0u128;
    for res in results {
        let (url, outcome, elapsed) = res.unwrap(); // unwrap JoinError
        total_ms += elapsed.as_millis();
        match outcome {
            Ok(Ok(_)) => {
                ok += 1;
                println!("OK  {} ({:?})", url, elapsed);
            }
            Ok(Err(e)) => {
                err += 1;
                println!("ERR {} — {}", url, e);
            }
            Err(_) => {
                err += 1;
                println!("TIMEOUT {}", url);
            }
        }
    }

    println!(
        "\nTotal: {} | OK: {} | Failed: {} | Avg: {}ms | Wall: {:?}",
        urls.len(),
        ok,
        err,
        if ok + err > 0 {
            total_ms / (ok + err) as u128
        } else {
            0
        },
        start.elapsed()
    );
}
