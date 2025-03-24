package threads;

public class Main {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        }).start();

        new Thread(() -> {
            System.out.println("Hello");
        }).start();
    }
}