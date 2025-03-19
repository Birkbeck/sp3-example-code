package example07;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterProblem {
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

class Counter {
    //private int count = 0;
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        //count++;
        count.incrementAndGet();
    }

    public int getCount() {
        // return count;
        return count.get();
    }
}

class CounterRunnable implements Runnable {
    private Counter counter;

    public CounterRunnable(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100_000; i++) {
            counter.increment();
        }
//        System.out.println(counter.getCount());
    }
}