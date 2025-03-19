package example06;

import java.util.Scanner;

public class Primes {
    private final static int MAX = 10_000_000;

    private class CountPrimes extends Thread {
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

    public static void main(String[] args) {
        int numberOfThreads = 0;
        Scanner sc = new Scanner(System.in);
        while (numberOfThreads < 1 || numberOfThreads > 25) {
            System.out.print("Enter number of threads (1-25): ");
            numberOfThreads = sc.nextInt();
        }
        System.out.println("Counting primes using " + numberOfThreads + " threads");
        CountPrimes[] threads = new CountPrimes[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Primes().new CountPrimes(i);
            if (i % 2 != 0) {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }
            System.out.println("Starting thread " + i + " with priority " + threads[i].getPriority());
            threads[i].start();
        }
        System.out.println("All threads started");
    }
}
