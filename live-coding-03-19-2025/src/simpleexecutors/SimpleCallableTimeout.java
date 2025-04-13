package simpleexecutors;

import java.util.concurrent.*;

public class SimpleCallableTimeout {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.err.println("Time's up! - ");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.getMessage());
        }
    }
}
