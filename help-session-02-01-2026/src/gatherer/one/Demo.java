package gatherer.one;


// Gatherers enable us to group (or window) elements

import java.util.List;
import java.util.stream.Gatherers;

public class Demo {
    static void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Group the elements into blocks of 3
        List<List<Integer>> windows = numbers.stream()
                .gather(Gatherers.windowFixed(3))
                .toList(); // .collect(Collectors.toList())
        System.out.println(windows);

        windows = numbers.stream()
                .gather(Gatherers.windowSliding(2))
                .toList();
        System.out.println(windows);
    }
}
