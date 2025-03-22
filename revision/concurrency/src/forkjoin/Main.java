package forkjoin;

import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.ForkJoinPool.commonPool;

public class Main {
    public static void main(String[] args) {
        Problem test = new Problem();
        long startTime = System.nanoTime();

        Solver mfj = new Solver(test.getList());
        try (ForkJoinPool pool = commonPool()) {
            pool.invoke(mfj);
        }
        long result = mfj.getResult();
        // Stop measuring execution time
        long endTime = System.nanoTime();
        // Calculate the execution time in milliseconds
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Done. Result: " + result + " in " + executionTime + "ms");


        startTime = System.nanoTime();
        long sum = 0;
        // check if the result was ok
        for (int i = 0; i < test.getList().length; i++) {
            sum += test.getList()[i];
        }
        endTime = System.nanoTime();
        executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Done. Result: " + sum + " in " + executionTime + "ms");
    }
}
