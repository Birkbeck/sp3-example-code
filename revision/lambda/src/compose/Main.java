package compose;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;

        Function<Integer, Integer> multiplyBy2AndAdd1 = multiplyBy2.andThen(add1);
        Function<Integer, Integer> add1AndMultiplyBy2 = compose(add1, multiplyBy2);

        System.out.println(multiplyBy2AndAdd1.apply(2));
        System.out.println(add1AndMultiplyBy2.apply(2)); // 6

    }

    /**
     * Compose two functions.
     *
     * @param f function A->B
     * @param g function B->C
     * @return new function A->C formed by composing f with g
     */
    static <A, B, C> Function<A, C> compose(Function<A, B> f,
                                            Function<B, C> g) {
        return t -> g.apply(f.apply(t));
    }

    static <A, B, C> Function<A, C> compose2(Function<A, B> f,
                                             Function<B, C> g) {
        return new Function<>() {
            @Override
            public C apply(A t) {
                return g.apply(f.apply(t));
            }
        };
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }
}
