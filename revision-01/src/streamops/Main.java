package streamops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers);
        // Map
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squared);

        // Filter
        List<Integer> even = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(even);

        // Reduce
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // Zip (using a custom method)
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<String> zipped = zip(numbers, letters);

        System.out.println(zipped);

    }

    public static <A, B> List<String> zip(List<A> listA, List<B> listB) {
        return listA.stream()
                .map(x -> listB.get(listA.indexOf(x)) + x.toString())
                .toList();
    }
}
