package threads.and.blocking.tasks;

import java.net.URL;
import java.util.Scanner;

import static threads.and.blocking.tasks.Latch.latch;

public class Sample {
    public static String readResponse(int id) {
        try {
            System.out.format("making request %d from %s\n", id, Thread.currentThread());

            URL url = new URL("http://httpstat.us/200?sleep=5000");
            String response = new Scanner(url.openStream()).nextLine();

            System.out.format("received response %d from %s\n", id, Thread.currentThread());

            return response;
        } catch (Exception ex) {
            return ex.getMessage();
        } finally {
            latch.countDown();
        }
    }
}

