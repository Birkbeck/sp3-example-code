public class Sample {
  public static void nap() {
    try { Thread.sleep(5000); } catch(Exception ex) {}
  }

  public static void main(String[] args) throws Exception {
    int MAX = 1_000_000; //Let's increase the number and see the limits
    Thread thread = null;

    for(int i = 0; i < MAX; i++) {
      //thread = new Thread(Sample::nap);
      //thread.start();

      thread = Thread.startVirtualThread(Sample::nap);
    }

    System.out.println("started " + MAX + " threads");

    thread.join();

    System.out.println("done");
  }
}

