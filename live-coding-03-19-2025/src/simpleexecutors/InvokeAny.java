package simpleexecutors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAny {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
            callable("task1", 2),
            callable("task2", 1),
            callable("task3", 3));

        try {
            String result = executor.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
