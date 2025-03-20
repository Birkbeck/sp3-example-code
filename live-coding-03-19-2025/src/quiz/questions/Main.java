package quiz.questions;

public class Main {
    public static void main(String[] args) {
        var thread1 = new Thread(() ->
                System.out.println("Hello World from Runnable!"));
        thread1.start();

        var thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello World from subclass!");
            }
        };
        thread2.start();

        Thread daemon = new Thread(()
                -> System.out.println("Hello from daemon!"));
        daemon.setDaemon(true);
        daemon.start();
    }
}