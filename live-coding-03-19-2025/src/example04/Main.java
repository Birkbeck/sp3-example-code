package example04;

public class Main {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of main thread.");
    }
}
