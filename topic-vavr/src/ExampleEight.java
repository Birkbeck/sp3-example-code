import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;

import java.io.Serializable;

public class ExampleEight {
    public static void main(String... args) {
        Tuple2<Integer, Integer> input = Tuple.of(54,24);

        Try<Serializable> result = gcdRecursion(input._1, input._2);

        System.out.println("GCD of " + input + " is " + result.getOrElse(0));
    }

    public static Try<Serializable> gcdRecursion(int a, int b){
        return Try.of(() -> {
            if (b == 0) {
                return a;
            } else {
                return gcdRecursion(b, a % b);
            }
        });
    }
}
