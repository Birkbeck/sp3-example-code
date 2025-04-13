package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static utils.ConcurrentUtils.stop;

public class Problems {
    private static int count = 0;

    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            run();
        }
    }

    static void run() {
        count = 0;
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10_000)
                .forEach(i -> executor.submit(Problems::increment));

        stop(executor);

        System.out.println(count);  // 9965

    }

    static void increment() {
        count++;
    }

    synchronized static void incrementSync() {
        count++;
    }

}
