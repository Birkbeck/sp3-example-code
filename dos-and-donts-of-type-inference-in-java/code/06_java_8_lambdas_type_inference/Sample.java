import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numbers.forEach((Integer e) -> System.out.println(e));
        //The type is obvious here from the context. We can drop the type information

        numbers.forEach((e) -> System.out.println(e));
        //One benefit of using type inference here is we can drop the ()

        numbers.forEach(e -> System.out.println(e));
    }
}