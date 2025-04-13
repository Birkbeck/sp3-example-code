import java.util.*;

public class Sample {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello");
        //var runnable = () -> System.out.println("hello"); //ERROR

        runnable.run();
    }
}
