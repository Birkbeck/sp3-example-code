package exampleone;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(15);
        numbers.add(59);
        numbers.add(115);
        numbers.add(-5);

        // parameter -> expression
        // (para1, para2) -> expression
        // para -> { code block }
        // (para1, para2) -> { code block }

        // numbers.forEach( n -> System.out.println(n));
        // numbers.forEach(System.out::println); // method reference

        Consumer<Integer> method = System.out::println;//n -> System.out.println(n);
        numbers.forEach(method);
    }
}
