package concurrency03;

public class SimpleThreads {

    // Display thread message
    static void threadMessage(String message) {
        var threadName = Thread.currentThread().getName();
        System.out.format("%s: %s\n", threadName, message);
    }
}
