package simplerunnable;

import java.util.concurrent.TimeUnit;

public class SimpleThreads {

    public static void main(String[] args) {
        test1("Without delay");
        test2("With sleep");
        test3("With sleep and TimeUnit");
    }

    private static void test1(String msg) {
        System.out.println(msg);
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Done!");
    }

    private static void test2(String msg) {
        System.out.println(msg);
        Runnable runnable = () -> {
            try {
                System.out.println("Foo " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Bar " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void test3(String msg) {
        System.out.println(msg);
        Runnable runnable = () -> {
            try {
                System.out.println("Foo " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}