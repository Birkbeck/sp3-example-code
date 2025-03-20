package mf.qcon.examples.example02;

import java.util.*;
import java.util.function.*;

public class Behavior {

    public static int sum(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int n : numbers) {
            if (p.test(n)) {
                total += n;
            }
        }
        return total;
    }

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(sum(numbers, n -> true));
        System.out.println(sum(numbers, n -> n % 2 == 0));
    }
}
