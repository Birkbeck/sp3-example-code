package map;

import java.util.Arrays;
import java.util.function.Function;

public class Main {

    public static void main(String... args) {
        var result = Map.map(toLowerCase, Arrays.asList("A", "b", "C"));
        System.out.println(result);

        result = Map.map(s -> s.toLowerCase(), Arrays.asList("A", "b", "C"));
        System.out.println(result);
        // --or--
        result = Map.map((s) -> s.toLowerCase(), Arrays.asList("A", "b", "C"));
        System.out.println(result);
        // --or--
        result = Map.map((s) -> {
            return s.toLowerCase();
        }, Arrays.asList("A", "b", "C"));
        System.out.println(result);

        // --or--
        result = Map.map(String::toLowerCase, Arrays.asList("A", "b", "C"));
        System.out.println(result);
    }

    static Function<String, String> toLowerCase = new Function<>() {
        @Override
        public String apply(String s) {
            return s.toLowerCase();
        }
    };
}
