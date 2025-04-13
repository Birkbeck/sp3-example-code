package example06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 0;
        Scanner sc = new Scanner(System.in);
        while (numberOfThreads < 1 || numberOfThreads > 25) {
            System.out.print("Enter number of threads (1-25): ");
            numberOfThreads = sc.nextInt();
        }
        System.out.println("Counting primes using " + numberOfThreads + " threads");
        Primes.CountPrimes[] threads = new Primes.CountPrimes[numberOfThreads];
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
