package reflection.question4;

import java.io.File;

public class Driver {

    public static void main(String[] args) {
        File f = new File("test.txt");
        String s = "Hello";
        System.out.println(UniversalToString.toString(s));
        System.out.println(UniversalToString.toString(f));
    }
}