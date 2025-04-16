package concurrency02;

import java.time.Duration;
import java.time.Instant;

public class Main {
    static final int N = 100;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < N; i++) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        };

        new Thread(runnable).start();
        var vThread = Thread.ofVirtual().start(runnable);

        vThread.join();
        System.out.printf("Main thread exiting\n");

    }
}
