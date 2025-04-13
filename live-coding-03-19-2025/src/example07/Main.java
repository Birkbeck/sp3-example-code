package example07;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(new CounterRunnable(counter));
        Thread t2 = new Thread(new CounterRunnable(counter));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("The value of the counter is " + counter.getCount());
    }
}

