package concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloLoom {
    public static void main(String[] args) throws InterruptedException {

        final AtomicInteger atomicInteger = new AtomicInteger();

        Runnable runnable = () -> {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (Exception e) {
                System.out.println(e);
            }
            //System.out.println("Work Done - " + atomicInteger.incrementAndGet());
        };
//        doIt(Executors.newCachedThreadPool(), runnable, "Total elapsed time for cached thread pool: ");
//        doIt(Executors.newVirtualThreadPerTaskExecutor(), runnable, "Total elapsed time for virtual threads: ");

        long sumPool = 0L;
        long sumVirtual = 0L;
        final int DURATION = 10;

        for (var x = 0; x < DURATION; x++) {
            sumPool += doIt(Executors.newCachedThreadPool(), runnable, "Total elapsed time for cached thread pool: ");
            sumVirtual += doIt(Executors.newVirtualThreadPerTaskExecutor(), runnable, "Total elapsed time for virtual threads: ");
        }
        System.out.format("Average time elapsed for cached thread pool %d%n", sumPool / DURATION);
        System.out.format("Average time elapsed for virtual threads %d%n", sumVirtual / DURATION);
    }

    private static long doIt(ExecutorService ex, Runnable runnable, String message) {
        Instant start = Instant.now();

        try (var executor = ex) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
        System.out.println(message + timeElapsed);
        return timeElapsed;
    }
}