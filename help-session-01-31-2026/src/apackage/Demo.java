package apackage;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo {
    static void main() {
        List<Integer> transactions = Arrays.asList(100, 250, 50, 500);

//        int total = transactions.stream()
//                .reduce(0, Integer::sum);
//        System.out.printf("Total amount of transactions: %d%n", total);

        IntSummaryStatistics stats = transactions.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.printf("Average amount of transactions: %5.2f%n", stats.getAverage());
        System.out.printf("Max amount of transactions: %d%n", stats.getMax());
        System.out.printf("Min amount of transactions: %d%n", stats.getMin());
        System.out.printf("Sum of transactions: %d%n", stats.getSum());
    }
}
