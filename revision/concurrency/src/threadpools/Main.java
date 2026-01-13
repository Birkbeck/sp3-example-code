package threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {
    private static final int NO_OF_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService executor = newFixedThreadPool(NO_OF_THREADS);
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        boolean code = false;
        try {
            code = executor.awaitTermination(50, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("tasks interrupted " + e.getMessage());
        }
        System.out.println("All threads are finished: " + code);
    }
}