package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CancelATask {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = executor
                .schedule(() -> {
                    System.out.println("Some Task");
                }, 5, TimeUnit.SECONDS);

        System.out.println("Before Cancel - Task is done : " + future.isDone());
        System.out.println("Before Cancel - Task is cancelled : " + future.isCancelled());

        if (!future.isDone()) {
            future.cancel(false);
        }

        System.out.println("Before Cancel - Task is done : " + future.isDone());
        System.out.println("Before Cancel - Task is cancelled : " + future.isCancelled());

        executor.shutdown();
    }
}