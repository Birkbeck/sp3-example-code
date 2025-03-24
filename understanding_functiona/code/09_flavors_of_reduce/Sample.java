import java.util.*;

import static java.util.stream.Collectors.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        var result = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toList());
        //.collect(toSet());

        System.out.println(result);
    }
}


