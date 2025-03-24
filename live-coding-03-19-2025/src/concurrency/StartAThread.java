package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartAThread {

    public static void main(String[] args) {
        var subTask = new SubTask();
        subTask.start();

        var subTaskWithRunnable = new Thread(new SubTaskWithRunnable());
        subTaskWithRunnable.start();

        Runnable subTaskWithLambda = () -> {
            System.out.println("SubTaskWithLambda started...");
        };

        Thread subTask1 = new Thread(subTaskWithLambda);
        subTask1.start();

        //virtual thread
        Runnable runnable = () -> System.out.println("Inside Runnable");
        Thread.startVirtualThread(runnable);

        //or

        Thread.startVirtualThread(() -> {
            //Code to execute in virtual thread
            System.out.println("Inside Runnable");
        });

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() ->
        {
            System.out.println("SubTaskWithLambda started... from executor");
        });
    }
}

class SubTask extends Thread {

    @Override
    public void run() {
        System.out.println("SubTask started...");
    }
}

class SubTaskWithRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("SubTaskWithRunnable started...");
    }
}
