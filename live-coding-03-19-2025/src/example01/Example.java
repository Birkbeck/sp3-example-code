package example01;

public class Example {
    public static void main(String[] args) {
        var t1 = new NamedThread("Thread 1");
        var t2 = new NamedThread("Thread 2");
        t1.start();
        t2.start();
    }
}
