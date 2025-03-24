package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {
    public static void main(String... args) {
        String[] friends = {"Peter", "Paul", "Mary"};

        Arrays.sort(friends, (first, second) -> first.length() - second.length());
        Arrays.sort(friends, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(friends));
        // [Paul, Mary, Peter]


//    List<String> enemies = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));
//    enemies.removeIf(e -> e == null);
//    System.out.println(enemies);
    }
}
