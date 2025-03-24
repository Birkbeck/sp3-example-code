import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;

public class ExampleTwo {
    public static void main(String[] args) {
        Tuple2<String, Integer> tuple = Tuple.of("Hello, World!", 42);
        System.out.println(tuple);
        System.out.println(tuple._1);
        System.out.println(tuple._2);

        Tuple3<String, Integer, Boolean> tuple3 = Tuple.of("Hello, World!", 42, true);
        System.out.println(tuple3);
        System.out.println(tuple3._1);
        System.out.println(tuple3._2);
        System.out.println(tuple3._3);
    }
}
