import io.vavr.Function5;

import java.sql.SQLOutput;
import java.util.function.Function;

public class ExampleFour {
    public static void main(String[] args) {
//        Function<Integer,Integer> square = x -> x * x;
//        int result = square.apply(5);
//        System.out.println(result);
        Function5<String,String, String, String, String, String> concat;
        concat = (a, b, c, d, e) -> {
            return a + b + c + d + e;
        };
        System.out.println(concat);
        System.out.println(concat.apply("a", "b", "c", "d", "e"));

    }
}
