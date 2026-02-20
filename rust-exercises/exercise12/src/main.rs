// Workers share the receiver via Arc<Mutex<Receiver>>.
// When the ThreadPool is dropped, the sender is dropped, which closes the channel.
// Workers detect this as a disconnect and exit cleanly.

use std::sync::mpsc::{self, Sender};
use std::sync::{Arc, Mutex};
use std::thread;

type Job = Box<dyn FnOnce() + Send + 'static>;

struct Worker {
    #[allow(dead_code)]
    id: usize,
    thread: Option<thread::JoinHandle<()>>,
}

impl Worker {
    fn new(id: usize, receiver: Arc<Mutex<mpsc::Receiver<Job>>>) -> Self {
        let thread = thread::spawn(move || {
            loop {
                // Lock, receive, then immediately drop the lock
                let job = receiver.lock().unwrap().recv();
                match job {
                    Ok(job) => {
                        println!("Worker {} executing job", id);
                        job();
                    }
                    Err(_) => {
                        // Channel closed — time to exit
                        println!("Worker {} shutting down", id);
                        break;
                    }
                }
            }
        });
        Worker {
            id,
            thread: Some(thread),
        }
    }
}

struct ThreadPool {
    workers: Vec<Worker>,
    sender: Option<Sender<Job>>,
}

impl ThreadPool {
    pub fn new(size: usize) -> Self {
        assert!(size > 0, "Pool size must be > 0");
        let (sender, receiver) = mpsc::channel::<Job>();
        let receiver = Arc::new(Mutex::new(receiver));
        let workers = (0..size)
            .map(|id| Worker::new(id, Arc::clone(&receiver)))
            .collect();
        ThreadPool {
            workers,
            sender: Some(sender),
        }
    }

    pub fn execute<F: FnOnce() + Send + 'static>(&self, f: F) {
        self.sender
            .as_ref()
            .expect("pool already shut down")
            .send(Box::new(f))
            .expect("failed to send job");
    }
}

impl Drop for ThreadPool {
    fn drop(&mut self) {
        // Drop the sender first — this closes the channel
        drop(self.sender.take());
        // Then join all worker threads
        for w in &mut self.workers {
            if let Some(t) = w.thread.take() {
                t.join().expect("worker thread panicked");
            }
        }
    }
}

fn main() {
    let pool = ThreadPool::new(4);
    let start = std::time::Instant::now();

    for i in 0..8 {
        pool.execute(move || {
            thread::sleep(std::time::Duration::from_millis(50));
            println!("Job {} done", i);
        });
    }

    drop(pool); // blocks until all jobs finish
    println!("All jobs complete in {:?}", start.elapsed());
    // With 4 workers and 8x50ms jobs → ~100ms wall time
}
