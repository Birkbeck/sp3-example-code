package example06;

import java.util.Scanner;

public class Primes {
    private final static int MAX = 20_000_000;

    private static int countPrimes(int from, int to) {
        int count = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    class CountPrimes extends Thread {
        int id;

        public CountPrimes(int id) {
            this.id = id;
        }

        public void run() {
            long startTime = System.currentTimeMillis();
            int count = countPrimes(2, MAX);
            long endTime = System.currentTimeMillis();
            System.out.println("Thread " + id + " counted " + count + " primes in " + (endTime - startTime) + " ms");
        }
    }
}
