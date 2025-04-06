import java.util.*;
import java.util.concurrent.*;
import java.net.URL;

public class Sample {
  private static int MAX = 5;
  private static CountDownLatch latch = new CountDownLatch(MAX);

  public static String readResponse(int id) {
    try {
      System.out.println("making request " + id + " from " + Thread.currentThread());

      URL url = new URL("http://httpstat.us/200?sleep=5000");
      String response = new Scanner(url.openStream()).nextLine();

      System.out.println("received response " + id + " from " + Thread.currentThread());

      return response;
    } catch(Exception ex) {
      return ex.getMessage();
    } finally {
      latch.countDown();
    }
  }

  public static void main(String[] args) throws Exception {
    for(int i = 0; i < MAX; i++) {
      int index = i;
      new Thread(() -> readResponse(index)).start();
    }

    latch.await();

    System.out.println("done");
  }
}

