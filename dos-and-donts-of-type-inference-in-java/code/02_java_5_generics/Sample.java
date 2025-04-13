import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();

        names.<String>add("Jack");
        names.add("Jill");

        //type inference - we use this so much that we forget
        //about the names.<String>add(...) version

        System.out.println(names);
    }
}
