package example07;

class CounterRunnable implements Runnable {
    private Counter counter;

    public CounterRunnable(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100_000; i++) {
            counter.increment();
        }
    }
}