package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallbackTwo {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        // configure CompletableFuture
        CompletableFuture<Integer> futureCount = createCompletableFuture();

        // continue to do other work
        System.out.println("Took " + (System.currentTimeMillis() - started) + " milliseconds");

        // now it is time to get the result
        try {
            int count = futureCount.get();
            System.out.println("CompletableFuture took " + (System.currentTimeMillis() - started) + " milliseconds");

            System.out.println("Result " + count);
        } catch (InterruptedException | ExecutionException ex) {
            // Exceptions from the future should be handled here
        }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        // simulate long running task
                        Thread.sleep(5000);
                    } catch (InterruptedException _) {
                    }
                    return 20;
                });
    }

}