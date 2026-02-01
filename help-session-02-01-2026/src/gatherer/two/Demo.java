package gatherer.two;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;

public class Demo {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> runningTotal = numbers.stream()
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();
        System.out.println("Running total: " + runningTotal);

        Map<String, List<Integer>> buckets = numbers.stream()
                .collect(Collectors.groupingBy(n -> n < 5 ? "Low": "High"));
        System.out.println("Buckets: " + buckets);
    }
}
