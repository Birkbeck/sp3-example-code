import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    //If we have a one-to-one function, then
    //Stream<T>.map(fTR) => Stream<R>
    List<Integer> result1 = numbers.stream()
      .map(e -> e * 2)
      .collect(toList());
    //we transform from a collection to a collection

    System.out.println(result1);

    //If we have a one-to-many function, then
    //Stream<T>.map(fTList<R>) => Stream<List<R>>
    List<List<Integer>> result2 = numbers.stream()
      .map(e -> List.of(e - 1, e + 1))
      .collect(toList());
    //we transform from a collection to a collection of collection

    System.out.println(result2);


    //if you want a collection of collection, you got it.

    //But if you wanted a collection of data in the end, map is not
    //suitable.
    List<Integer> result3 = numbers.stream()
      .flatMap(e -> List.of(e - 1, e + 1).stream())
      .collect(toList());
    //we transform from a collection to a collection
    
    System.out.println(result3);
  }
}

/*
If you have a one-to-one function, then use map to transform
If you have a one-to-many function, then use a flatMap to transform
*/


