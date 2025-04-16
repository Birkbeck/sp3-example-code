package concurrency03;

import static concurrency03.SimpleThreads.threadMessage;

public class Main {
    static final int WAITING_TIME = 5000;

    public static void main(String[] args) throws InterruptedException {
        threadMessage("Starting MessageLoop");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage(("Waiting for MessageLoop to finish"));
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            t.join(1000);
            if ((System.currentTimeMillis() - startTime) > WAITING_TIME
                    && t.isAlive()) {
                threadMessage("Tired of waiting...");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finished MessageLoop");
    }
}
