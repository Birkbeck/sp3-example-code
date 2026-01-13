package simpleexecutors;

import java.util.concurrent.*;

public class SimpleCallable {
    public static void main(String[] args) {

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        try {
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(task);

            System.out.println("future done? " + future.isDone());

            Integer result = future.get();

            System.out.println("future done? " + future.isDone());
            System.out.print("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.getMessage());
        }
    }
}
