import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numbers.forEach((Integer e) -> System.out.println(e));

        numbers.forEach(e -> System.out.println(e));

        numbers.forEach((var e) -> System.out.println(e));
    }
}