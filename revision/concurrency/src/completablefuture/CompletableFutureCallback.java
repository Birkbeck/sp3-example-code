package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {
    public static void main(String[] args) {
        CompletableFuture<String> data = createCompletableFuture()
                .thenApply((Integer count) -> count * 10)
                .thenApply(transformed -> "Finally creates a string: " + transformed);
        System.out.println("...");
        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {

        }
    }

    public static CompletableFuture<Integer> createCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long running task
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            return 20;
        });
    }

}