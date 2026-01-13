import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        numbers.stream() //Stream<Integer>
                .map(e -> e * 2.0) //Stream<Double>
                .forEach(System.out::println);
    }
}

/*
  [x1, x2, ..., xn].map(f) => [y1, y2, ..., yn]

  where

  xi = f(xi)

  map applies (why the Function's method is called apply) the given function
  to each element in the incoming collection to result in an outgoing collection

  map takes a function

  # of elements in the output == # of element in the input

  However,

  the output values and type may be different from the input values and type
*/
