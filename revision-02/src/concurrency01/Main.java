package concurrency01;

public class Main {
    public static void main(String[] args) {
        var thread = new MyThread();
        thread.start();

        var thread2 = new Thread(new MyRunnable());
        thread2.start();

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.printf("Hello %s!%n", Thread.currentThread().getName());
            }
        };
        new Thread(runnable).start();

        Runnable runnable2 = () -> {
            System.out.printf("Hello %s!%n", Thread.currentThread().getName());
        };
        new Thread(runnable2).start();

    }
}

class MyThread extends Thread {
    public void run() {
        System.out.printf("MyThread.run() — %s!%n", Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.printf("MyRunnable.run() — %s!%n", Thread.currentThread().getName());
    }
}