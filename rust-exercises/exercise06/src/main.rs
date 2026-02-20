// Closures that capture by reference implement Fn.
// Those that capture by mutable reference implement FnMut.
// Those that consume captured values implement FnOnce only.
// The hierarchy is FnOnce ⊇ FnMut ⊇ Fn.

use std::collections::HashMap;

// ── Pipeline of transformations ──────────────────────────────────────
fn pipeline(data: Vec<i32>, transforms: Vec<Box<dyn Fn(i32) -> i32>>) -> Vec<i32> {
    data.into_iter()
        .map(|x| transforms.iter().fold(x, |acc, f| f(acc)))
        .collect()
}

// ── Function composition ─────────────────────────────────────────────
fn compose<F, G>(f: F, g: G) -> impl Fn(i32) -> i32
where
    F: Fn(i32) -> i32,
    G: Fn(i32) -> i32,
{
    move |x| g(f(x))
}

// ── Memoization ──────────────────────────────────────────────────────
fn memoize<F>(mut f: F) -> impl FnMut(i32) -> i32
where
    F: FnMut(i32) -> i32,
{
    let mut cache: HashMap<i32, i32> = HashMap::new();
    move |x| {
        if let Some(&cached) = cache.get(&x) {
            return cached;
        }
        let result = f(x);
        cache.insert(x, result);
        result
    }
}

// ── Retry with FnMut ─────────────────────────────────────────────────
fn retry<F: FnMut() -> Result<(), String>>(mut f: F, attempts: u32) -> Result<(), String> {
    for attempt in 1..=attempts {
        match f() {
            Ok(()) => return Ok(()),
            Err(e) => {
                eprintln!("Attempt {}/{} failed: {}", attempt, attempts, e);
                if attempt == attempts {
                    return Err(e);
                }
            }
        }
    }
    unreachable!()
}

fn main() {
    // Pipeline
    let transforms: Vec<Box<dyn Fn(i32) -> i32>> = vec![
        Box::new(|x| x * 2),
        Box::new(|x| x + 1),
        Box::new(|x| x * x),
    ];
    println!("{:?}", pipeline(vec![1, 2, 3], transforms)); // [9, 25, 49]

    // Composition: double then add ten
    let double_then_add10 = compose(|x| x * 2, |x| x + 10);
    println!("{}", double_then_add10(5)); // 20

    // Memoized expensive computation
    let mut memo_square = memoize(|x| {
        println!("computing {}", x);
        x * x
    });
    memo_square(4); // prints 'computing 4'
    memo_square(4); // cache hit — nothing printed

    // Retry
    let mut count = 0;
    let result = retry(
        || {
            count += 1;
            if count < 3 {
                Err("not yet".to_string())
            } else {
                Ok(())
            }
        },
        5,
    );
    println!("{:?}", result); // Ok(())

    // ── FnOnce demo ──────────────────────────────────────────────────
    let s = String::from("consumed");
    let once_closure = move || {
        println!("{}", s);
    }; // captures s by move
    once_closure(); // works
    // once_closure(); // ERROR: cannot call FnOnce closure more than once
}
