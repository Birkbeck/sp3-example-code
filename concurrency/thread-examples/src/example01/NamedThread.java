package example01;

public class NamedThread extends Thread {
    private String name;

    public NamedThread(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Running thread " + name);
    }
}
