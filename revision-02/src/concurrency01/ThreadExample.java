package concurrency01;

public class ThreadExample {
    final static int N = 100;

    public static void main(String[] args) {
        System.out.printf("Thread: %s\n", Thread.currentThread().getName());
        for (int i = 0; i < N; i++) {
            new Thread("" + i) {
                public void run() {
//                    try {
//                        Thread.sleep(10000L);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    System.out.printf("Thread: %s running\n",
                            Thread.currentThread().getName());
                }
            }.start();
        }
    }
}
