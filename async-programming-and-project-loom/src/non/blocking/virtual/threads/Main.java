package non.blocking.virtual.threads;

import static non.blocking.virtual.threads.Latch.latch;
import static non.blocking.virtual.threads.Latch.MAX;
import static non.blocking.virtual.threads.Sample.readResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < MAX; i++) {
            int index = i;
            //new Thread(() -> readResponse(index)).start();
            Thread.startVirtualThread(() -> readResponse(index));
        }

        latch.await();

        System.out.println("done");
    }
}
