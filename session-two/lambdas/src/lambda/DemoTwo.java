package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DemoTwo {
    // Predicate<T>  -> test
    // Consumer<T> -> accept
    // Function<T,R> -> apply Takes T returns R
    // Supplier<T> -> get
    static void main() {
        // Predicate: Is the string long? (>5)
        Predicate<String> isLong = s -> s.length() > 5;

        System.out.println(isLong.test("Java"));
        System.out.println(isLong.test("Java Again"));

        Function<String,Integer> getLength = s -> s.length() + 1;

        System.out.println(getLength.apply("Lambda"));

        List<String> fruits = Arrays.asList("Apple","Kiwi","Banana","Elderberry");

        for (String s : fruits){ // Cannot be concurrent
            System.out.println("Fruit: " + s);
        }
        // Consumer
        fruits.forEach(s -> System.out.println("Fruit: " + s));
        fruits.forEach(System.out::println);
        // Might be able to make this concurrent
    }
}
