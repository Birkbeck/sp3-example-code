package non.blocking.virtual.threads;

import java.net.URL;
import java.util.Scanner;

import static non.blocking.virtual.threads.Latch.latch;

public class Sample {
    public static String readResponse(int id) {
        try {
            System.out.println("making request " + id + " from " + Thread.currentThread());

            URL url = new URL("http://httpstat.us/200?sleep=5000");
            String response = new Scanner(url.openStream()).nextLine();

            System.out.println("received response " + id + " from " + Thread.currentThread());

            return response;
        } catch (Exception ex) {
            return ex.getMessage();
        } finally {
            latch.countDown();
        }
    }
}

