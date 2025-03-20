package threads.and.blocking.tasks;

import static threads.and.blocking.tasks.Sample.readResponse;
import static threads.and.blocking.tasks.Latch.latch;

public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < Latch.MAX; i++) {
            int index = i;
            new Thread(() -> readResponse(index)).start();
        }

        latch.await();

        System.out.println("done");
    }
}

