package concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableFutureExample {
    public static void main(String[] args) throws ExecutionException,
        InterruptedException, TimeoutException {

        var executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(new Work("Demo-Task"));

        var completedThread = future.get(5, TimeUnit.SECONDS);

        System.out.println("Thread completed with return value: " + completedThread);
    }
}

record Work(String name) implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        System.out.println("Task [" + name + "] executed on : " + LocalDateTime.now());
        Thread.sleep(10000);
        return name + "!";
    }
}