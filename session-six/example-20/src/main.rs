// ----- CONCURRENCY -----

// Concurrent programming envolves executing different blocks of code
// independently, while parallel programming is when different
// code executes at the same time. A thread handles scheduling
// and execution of these blocks of code.

// Common problems with parallel programming involve :
// 1. Thread are accessing data in the wrong order
// 2. Threads are blocked from executing because of confusion
// over requirements to proceed with execution

fn main() {
    use std::thread;
    use std::time::Duration;

    // Create a thread with spawn
    let thread1 = thread::spawn(|| {
        for i in 0..25 {
            println!("Spawned thread : {}", i);
            // Forces thread to sleep and allow another thread to execute
            thread::sleep(Duration::from_millis(1));
        }
    });

    // There are no guarantees on when the threads will execute and
    // that they will complete execution

    for i in 0..20 {
        println!("Main thread : {}", i);
        thread::sleep(Duration::from_millis(2));
    }

    // We call join here so that the main thread executes with thread1
    // unwrap handles the option Result which is Ok or Err

    thread1.join().unwrap();
}
