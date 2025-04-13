# Worksheet on Java Concurrency II

Once you have completed this worksheet, you should have achieved the following learning goals:

- Use the main classes from the package `java.util.concurrent`.
- Understand the concepts of the *thread pool* and *graceful degradation*.

Questions marked with `*` or `** `are advanced questions; you should not attempt them until you have completed the "ordinary" questions.

------

## 1. Responsive UI (that degrades gracefully) (*)

### a) Implement Executor

Create your implementation of `Executor`. Look at the documentation of the API of `Executor` for ideas. Your implementation must be able to execute one `Runnable` at a time (but you can make it run several tasks in parallel) and must have a queue of pending tasks. 

Try your implementation by exchanging the class you used in your solution for the former exercise with your new implementation of `Executor`. 

### b) Extend Executor

Create a class `TimedTask` that implements 'Runnable` where the `run()` method is only a call to `Thread.sleep()` for several milliseconds set at creation time. This number must be at most 1000 (if a higher number is given at construction time, it must be capped at 1000). 

Now extend your implementation of `Executor` to have a public method `getMaxPendingTime()` that returns the maximum theoretical time needed to run all tasks in the queue (i.e., assuming all of them last 1000 ms).

### c) Use Executor

Modify your solution to the original exercise *Responsive UI* so that:

- It has two classes: one represents the application, and one represents its users.
- The former uses your implementation of `Executor` with a pool of threads instead of plain threads.
- The latter will use an `Executor` from the Java Library to have a lot of threads representing users, and the threads will programmatically create new tasks instead of the human user doing it by hand, i.e., there is no need to ask the user to enter data at any point in this version of the exercise. Threads should create tasks as fast as the time they need to be run (e.g., if a task will make the thread sleep for one second, the next task should be created a second later). 
  - Any of the provided implementations will be fine. Please choose any of them and guess the appropriate values for the initialisation parameters. Ask the faculty members if you need help with this.  
- The application's class should implement a method `getMaxWait()` that returns the (theoretical) time needed to execute all tasks already in the queue.
- The `users` (threads) will ask for the waiting time before they assign a new task. If the wait is above a certain threshold (set at construction time for each `user`), the `user should print "the site is down! I will come back later..."` and wait a long time before sending more tasks. 

Try your implementation with different numbers of users and see how many users it can handle. 

### d) TimedRunnable (*)

Create an interface `TimedRunnable` that extends `Runnable` with a method `timeNeeded()`, that returns the time needed to run the tasks in milliseconds. Create a class that implements `TimedRunnable` where the `run()` method only calls to `Thread.sleep()` for several milliseconds set at creation time.

Now extend your implementation of `Executor` to execute both regular `Runnable` tasks and a `TimedRunnable`task. Both types of tasks should be stored in different queues. The class must also implement a public method `getExactTime()` that returns the sum of the time needed to run all `TimedRunnable` in the queue.

## 2. `BlockingQueue`

Write a program that uses a `BlockingQueue` to safely store and retrieve items between a producer and consumer thread.

## 3. `ReentrantReadWriteLock`

Simulate a bank account with deposits and withdrawals using a `ReentrantReadWriteLock`. Ensure proper synchronisation for read and write operations.

## 4. Countdown Latch

Implement a *countdown latch* that waits for tasks to finish executing before proceeding further.

## 5. `ExecutorService` and `Future`

Write code that uses an `ExecutorService` to execute multiple tasks concurrently. Demonstrate how to handle the results using a `Future` object.

## 6. `ReentrantLock` vs `synchronized`

Compare and contrast `synchronized` blocks and explicit synchronisation using `ReentrantLock` with code examples.

## 7. Race conditions

Write a program demonstrating the dangers of a race condition and how to solve it using the Java concurrency package synchronisation mechanisms.


## 8. Implementing Executor Services (**)

Create your implementation of `Executor`, `ExecutorService`, and `ScheduledExecutorService` with a thread pool of $n$,  where $n$ is set at construction time. Use your implementation in the former exercises.

## 9. Dining philosophers (*)

A weak-sighted philosopher gathered around a circular table to have dinner together. They were served on one big round plate in the middle of the table and given a fork each (so there was a fork on the table between every two adjacent philosophers). The philosophers discussed and agreed to adhere to the following protocol to prevent everybody from taking food simultaneously, risking their clumsy hands hacking at their neighbours with the forks. Each philosopher could only get food if they grabbed both forks on their left and right.

Write a program implementing a dinner with $n$ philosophers and $n$ forks. Make sure that only one philosopher can grab each fork at a time. Verify that a naive synchronisation strategy can quickly lead to a deadlock (when/why?); fix the program so this cannot occur. 

(**Hint:** During development, it may be helpful to implement a monitoring class (`Waiter`?)  that checks what the philosophers are doing, e.g., how many forks they have grabbed).

## 10. Graceful degradation everywhere

Think of three examples of concurrent applications you use every week that benefit from graceful degradation, i.e., becoming gradually slower under high load rather than crashing unexpectedly. Once you have thought of three examples, check them with one of your colleagues. Have you thought of the same examples?


------

End of worksheet