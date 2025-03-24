import java.util.*;

public class Sample {
    public static void main(String[] args) {
        //String greet = "hello";

        var greet = "hello";

        System.out.println(greet);

        greet = "howdy";
        System.out.println(greet);

        //greet.foo(); //ERROR at compile time, no foo() found for type String

        //greet = 1; //ERROR, int can't be converted to String
    }
}