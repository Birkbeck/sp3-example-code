package anexample;

// Java Streams API
/*
1. Source (e.g., a List, Set, Array,....)
2. Intermediate Operations — Transform the stream
    filter, map, etc.,
    These are LAZY
3. Terminal Operations: Produces a result (side-effect).
    collect, forEach, reduce, etc.

    FP — filter map reduce

    filter — condition ite divisible by 2.
    map — multiply the item by 2.
    reduce — add all the items up.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    static void main() {
        List<String> names = Arrays.asList("Alice", "Alan", "Bob", "Charlie", "Donald", "Mary", "Nigel");
//        for (String name : names) {
//            System.out.println(name);
//        }
        //names.forEach(System.out::println);
        var result = names.stream()
                .parallel()
                //.map(String::toUpperCase)
                .filter(name -> name.startsWith("A"))
                //.filter(name -> name.endsWith("N"))
                .sorted();
        //.toList();
        //.forEach(System.out::println);
//        result.forEach(System.out::println);
        System.out.println(result.getClass());
    }
}
