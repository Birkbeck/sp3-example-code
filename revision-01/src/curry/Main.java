package curry;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // currying example
        // where a function is transformed into a sequence
        // of functions, each with a single argument

        Function<Integer, Function<Integer, Integer>> multi = x -> y -> y * x;
        Function<Integer, Function<Integer, Integer>> which = x -> y -> y - x;

        Function<Integer, Integer> timesTen = multi.apply(10);
        Function<Integer, Integer> timesSeven = multi.apply(7);
        Function<Integer, Integer> whichEight = which.apply(8);

        System.out.println(timesTen.apply(5));
        System.out.println(timesSeven.apply(5));
        System.out.println(whichEight.apply(5));
    }
}
