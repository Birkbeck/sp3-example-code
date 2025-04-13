package hof;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> increment = x -> x + 1;

        System.out.println(square.apply(5));
        System.out.println(increment.apply(5));
        System.out.println(applyFunction(5, square));
        System.out.println(applyFunction(5, increment));


    }

    public static int applyFunction(int x, Function<Integer, Integer> f) {
        return f.apply(x);
    }
}
