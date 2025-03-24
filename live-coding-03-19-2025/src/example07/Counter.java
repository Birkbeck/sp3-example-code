package example07;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    //private int count = 0;
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        //count++;
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}