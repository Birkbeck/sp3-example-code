package example02;

public class NamedRunnable implements Runnable {
    private String name;

    public NamedRunnable(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Running thread " + name);
    }
}
