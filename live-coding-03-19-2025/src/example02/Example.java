package example02;

public class Example {
    public static void main(String[] args) {
        NamedRunnable r1 = new NamedRunnable("Thread 1");
        NamedRunnable r2 = new NamedRunnable("Thread 2");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
