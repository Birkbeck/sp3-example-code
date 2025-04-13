package mf.qcon.examples.example04;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

/**
 * Find all pair i, j such as:
 * - 0 < i <= j <= 20
 * - i + j is prime
 */
public class PrimeNumbers {

    public static final int LIMIT = 20;

    public static void main(String[] args) {
        System.out.println(
            IntStream.rangeClosed(1, LIMIT)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, i)
                    .mapToObj(j -> new int[]{i, j}))
                .peek(a -> System.out.println(Arrays.toString(a)))
                .filter(a -> isPrime(a[0] + a[1]))
                .map(Arrays::toString)
                .collect(toList())
        );
    }

    public static boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }
}
