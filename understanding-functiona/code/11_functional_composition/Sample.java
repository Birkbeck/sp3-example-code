import java.util.*;

import static java.util.stream.Collectors.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        var result = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toList());

        System.out.println(result);
    }
}

//Collection pipeline
//What is a stream?

//  List         vs         Stream
//  Bucket                  Pipeline
//  of data                 of function

//We create a pipeline of functions - functional composition

/*
source  |   grep someword  | awk ... | wc -l
            filter           map       reduce
air     |   purifier       | heater  | ...
water   |   purifier'      | cooler  | ...
*/

