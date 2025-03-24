import java.util.*;

public class Sample {
    public static void main(String[] args) {
        var list = new ArrayList<>(); //Bad idea

        list.add(1);
        list.add("a");

        //list is ArrayList Raw type

        System.out.println(list);
    }
}