package concurrency03;

import static concurrency03.SimpleThreads.threadMessage;

public class MessageLoop implements Runnable {

    @Override
    public void run() {
        String[] info = {
                "One",
                "Two",
                "Three",
                "Four"
        };

        try {
            for (String s : info) {
                Thread.sleep(4000);
                threadMessage(s);
            }
        } catch (InterruptedException ex) {
            threadMessage("I did not finish");
        }
    }
}
