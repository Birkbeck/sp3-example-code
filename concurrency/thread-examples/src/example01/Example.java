package example01;

public class Example {
    public static void main(String[] args) {
        NamedThread t1 = new NamedThread("Thread 1");
        NamedThread t2 = new NamedThread("Thread 2");
        t1.start();
        t2.start();
    }
}
