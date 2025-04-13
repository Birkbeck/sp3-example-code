import java.util.*;

public class Sample {
    public static void main(String[] args) {
        var runnable = (Runnable) (() -> System.out.println("hell")); //Please don't

        //Zero benefit
        //More noisy than before
        //Does not serve any purpose than annoying fellow programmers

        runnable.run();
    }
}