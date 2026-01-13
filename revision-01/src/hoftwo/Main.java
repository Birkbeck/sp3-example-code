package hoftwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    // define three functions: square, increment, toString
    // "Compose" (combine) those functions "andThen"
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers);

        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, String> toString = x -> "Number: " + x;

        // Composed functions

        Function<Integer, String> complexFunction =
                square.andThen(increment).andThen(toString);

        List<String> result = applyFunctionToList(numbers, complexFunction);

        System.out.println(result);
    }

    public static <T, R> List<R> applyFunctionToList(List<T> list, Function<T, R> f) {
        return list.stream()
                .map(f)
                .toList();
    }
}
