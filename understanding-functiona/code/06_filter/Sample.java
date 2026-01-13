import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }
}

/*
A filter is like a garage gate, letting some cars go though and tossing
others out.

filter takes a predicate

0 <= # of elements in the output <= # of elements in the input

The output is a subset of the input
*/
