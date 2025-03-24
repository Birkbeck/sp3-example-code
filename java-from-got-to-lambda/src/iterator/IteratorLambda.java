package iterator;

import java.util.List;

import static java.util.Arrays.asList;

public final class IteratorLambda {
    static final List<Integer> LIST = asList(1, 2, 3, 4, 5, 6);

    private IteratorLambda() {
    }

    public static void main(final String... args) {
        LIST.forEach(System.out::println);
    }
}
