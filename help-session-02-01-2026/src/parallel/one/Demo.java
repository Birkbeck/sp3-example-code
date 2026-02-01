package parallel.one;

import java.util.stream.LongStream;

public class Demo {
    static void main() {
        System.out.println("Parallel Version:");
        calculatePrimes(true);

        System.out.println("Sequential Primes:");
        calculatePrimes(false);
    }

    static void calculatePrimes(boolean parallel) {
        long start = System.currentTimeMillis();
        var  range = LongStream.rangeClosed(1, 1_000_000);
        var type = (parallel) ? range.parallel(): range;
        long count = type.filter(Demo::isPrime).count();
        long end = System.currentTimeMillis();

        System.out.printf("# Primes found: %d\n", count);
        System.out.printf("# Time taken: %d ms\n", (end - start));
    }

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}
