package folding;

import java.util.List;
import java.util.stream.Gatherer;

public class Demo {
    // Limit the cumulative sum
    static void main() {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60);
        int limit = 75;

        var result = numbers.stream()
                .gather(Gatherer.ofSequential(
                                () -> new int[1], // initial state — holds sum
                                (state, element, downstream) -> {
                                    state[0] += element;
                                    if (state[0] <= limit){
                                        return downstream.push(element);
                                    } else {
                                        return false;
                                    }
                                }
                        ))
                .toList();
        System.out.printf("Numbers included before limit: %d list: %s\n",limit, result);
    }
}
