import java.util.*;

import static java.util.stream.Collectors.*;

public class Sample {
    public static boolean check(int number) {
        System.out.println("check called for " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt called for " + number);
        return number * 2;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result1 = 0;

        for (int e : numbers) {
            if (check(e)) {
                result1 = doubleIt(e);
                break;
            }
        }

        System.out.println(result1);

        System.out.println("-------");

        int result2 = numbers.stream()
                .filter(Sample::check)
                .map(Sample::doubleIt)
                .findFirst()
                .orElse(0);

        System.out.println(result2);
    }
}

/*
There are two kinds of function that we call on a stream
Intermediate function and terminal function

The intermediate functions are fused together into a single function
and then they run, only minimally on demand when a terminal function 
is called.

*/

