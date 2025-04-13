package chain;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;

        Function<Integer, Integer> add1AndMultiplyBy2 = chain(List.of(add1, multiplyBy2));

        System.out.println(add1AndMultiplyBy2.apply(2)); // 6
    }

    /**
     * Compose a chain of functions.
     *
     * @param funcs list of functions A->A to compose
     * @return function A->A made by composing list[0] ... list[n-1]
     */
    static <A> Function<A, A> chain(@NotNull List<Function<A, A>> funcs) {
        return funcs.stream().reduce(Function.identity(), Function::compose);
    }
}
