
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Outline {
    private static final int TEN_THOUSAND = 10000;

    public static void main(String... args) { // varargs alternative to String[]
        Integer[] intArray = {1, 7, 3, 4, 8, 2};
        System.out.println(Arrays.asList(intArray));


        // 1. How would you use streams to filter the first two meat dishes?
        System.out.println("\n1.");
        var d = Dish.menu.stream().limit(2).collect(Collectors.toList());
        System.out.println(d);

        //Dish[] d2 = Dish.menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT)
        //        .toArray(Dish[]::new);
        //System.out.println(Arrays.asList(d2));

        // 2. How would you count the number of dishes in a stream using
        // the map and reduce methods?
        System.out.println("\n2.");
        long numberOfDishes = Dish.menu.stream().map(dish -> 1).reduce(0, Integer::sum);
        //numberOfDishes = Dish.menu.stream().map(dish -> 1).reduce(0, (a,b) -> a + b);
        System.out.println(numberOfDishes);

        // map(dish -> 1) is a Supplier function taking a Dish object and returning an int.
        // reduce(identity, accumulator) where identity is a starting value and the accumulator is a
        // binary function that adds the identity to the int passed from the preceding operation

        // 3. Given a list of numbers, how would you return a list of the square
        // of each number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].

        System.out.println("\n3.");
        List<Integer> squares = Arrays.stream(intArray).map(x -> x * x).collect(Collectors.toList());
        System.out.println(squares);

    /* 4. Given two lists of numbers, how would you return all pairs of numbers? For example,
    given a list [1, 2, 3] and a list [3, 4] you should return:
    [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
    For simplicity, you can represent a pair (x,y) as an array with two elements.*/

        System.out.println("\n4.");
        List<Integer> list1 = Arrays.asList(5, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<List<Integer>> output2 = list1.stream()
            .flatMap(num1 -> list2.stream().map(num2 -> Arrays.asList(num1, num2)))
            .collect(Collectors.toList());

        System.out.println(output2);


    /* 5. How would you extend the previous example to return only pairs whose
    sum is divisible by 3? For example, (2, 4) and (3, 3) are valid.  */

        System.out.println("\n5.");


        List<List<Integer>> output3 = list1.stream()
            .flatMap(num1 -> list2.stream().filter(num2 -> (num1 + num2) % 3 == 0)
                .map(num2 -> Arrays.asList(num1, num2)))
            .collect(Collectors.toList());
        System.out.println(output3);


        List<String> words = Arrays.asList("hi", "bat", "ear", "hello", "iguana", "beaver"
            , "winterland", "elephant", "eye", "qi");

    /* 6. Loop through the words and print each one on a separate line, with two spaces
    in front of each word. */

        System.out.println("\n6.");
        words.stream().forEach(w -> System.out.println("  " + w));

    /* 7. Repeat this problem but without two spaces in front of each word. This should
    be trivial if you use the same approach as the previous question; the point
    here is to make use of a method reference. */

        System.out.println("\n7.");
        words.stream().forEach(System.out::println);

    /* 8. For the following expressions, from the earlier questions, produce the same
    transformations using map:

    List<String> excitingWords = transformedList(words, s -> s + "!");
    List<String> eyeWords = transformedList(words, s -> s.replace("i", "eye"));
    List<String> upperCaseWords = transformedList(words, String::toUpperCase); */

        System.out.println("\n8.");

        List<String> excitingWords = words.stream()
            .map(s -> s + "!")
            .collect(Collectors.toList());

        List<String> eyeWords = words.stream()
            .map(s -> s.replace("i", "eye"))
            .collect(Collectors.toList());

        List<String> upperCaseWords = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(excitingWords);
        System.out.println(eyeWords);
        System.out.println(upperCaseWords);

    /* 9. For the following lists produce the same transformations using
    filter (you wrote solutions for the earlier questions):

    List<String> shortWords = allMatches(words, s -> s.length() < 4);
    List<String> wordsWithB = allMatches(words, s -> s.contains("b"));
    List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);  */

        System.out.println("\n9.");

        List<String> shortWords = words.stream()
            .filter(s -> s.length() < 4)
            .collect(Collectors.toList());

        List<String> wordsWithB = words.stream()
            .filter(s -> s.contains("b"))
            .collect(Collectors.toList());

        List<String> evenLengthWords = words.stream()
            .filter(s -> (s.length() % 2) == 0)
            .collect(Collectors.toList());

        System.out.println(shortWords);
        System.out.println(wordsWithB);
        System.out.println(evenLengthWords);

    /* 10. (*) Turn the strings in the array words into uppercase, keep only the
    ones that are shorter than four characters, and, of what is remaining,
    keep only the ones that contain "e", and print the first result. Repeat
    the process, except checking for a "q" instead of an "e". */

        System.out.println("\n10a.");
        words.stream()
            .filter(s -> s.length() < 4 && s.contains("e"))
            .map(String::toUpperCase)
            .limit(1)
            .forEach(System.out::println);

        System.out.println("\n10b.");
        words.stream()
            .filter(s -> s.length() < 4 && s.contains("q"))
            .map(String::toUpperCase)
            .limit(1)
            .forEach(System.out::println);

    /* 11. (** ) The above example uses lazy evaluation, but it is not easy to see
    that it is doing so. Create a variation of the above example that shows
    that it is doing lazy evaluation. The simplest way is to track which
     entries are turned into upper case. */

        System.out.println("\n11.");
    /*
    words.stream().filter(s -> {
              System.out.println("pre-filter1: " + s);
              return s.length() < 4 && s.contains("e");
            })
            .map(String::toUpperCase)
            .forEach(System.out::println);
     */

        words.stream().peek(s -> System.out.println("pre-filter2: " + s))
            .filter(s -> s.length() < 4 && s.contains("e"))
            .map(String::toUpperCase)
            .forEach(System.out::println);

    /* 12. (*) Write a static method that produces a List of a specified length of
    random numbers. For example,
    List<Double> nums = randomNumberList(someSize);
    Result is something like [0.7096867136897776, 0.09894202723079482, ...]   */

        System.out.println("\n12.");
        List<Double> randDoubles = randomNumberList(4);
        System.out.println(randDoubles);

    /* 13. (*) Write a static method that produces a list of numbers that go in order
    by a step size. For example,
    List<Integer> nums = orderedNumberList(50, 5, someSize);
    // Result is [50, 55, 60, ...] */

        System.out.println("\n13.");
        List<Integer> stepInts = orderedNumberList(50, 5, 4);
        System.out.println(stepInts);

    /* 14. (*) Provide three ways to use streams to compute the sum of a list of
     numbers. */

        System.out.println("\n14.");
        int sum1 = list1.stream().reduce((n1, n2) -> n1 + n2).get();
        int sum2 = list1.stream().reduce(0, Integer::sum);
        int sum3 = list1.stream().collect(Collectors.summingInt(n -> n));
        int sum4 = list1.stream().mapToInt(n -> n).sum();
        int sum5 = list1.stream().collect(Collectors.reducing(0, (n1, n2) -> n1 + n2));

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);
        System.out.println(sum5);

    /* 15. (*) Rewrite one of the solutions from the previous question so that
    it can be executed in parallel; verify that you get the same answer as for
    the sequential code. */

        System.out.println("\n15.");
        int sumP = list1.parallelStream()
            .reduce((n1, n2) -> n1 + n2).get();
        System.out.println(sumP);

    /* 16. (**) Now, use streams to compute the product of some doubles. Show that
    the serial and parallel versions do not always result in the same answer. */

        System.out.println("\n16.");
        Double[] doubleArray = {2.0, 7.0, 3.0, 4.0, 8.0, 2.0};
        double productDouble = Stream.of(doubleArray)
            .reduce(1.0, (n1, n2) -> n1 * n2);
        System.out.println(productDouble);

        BinaryOperator<Double> dProduct = (aDouble, aDouble2) -> aDouble * aDouble2;

        // Ouch! "for" loop...
        for (int i = 0; i < TEN_THOUSAND; i++) {
            double productDoubleP = Stream.of(doubleArray)
                .parallel()
                .collect(Collectors.reducing(1.0, (aDouble, aDouble2) -> aDouble * aDouble2));
            if (productDouble != productDoubleP) {
                System.out.println("Not equal (" + i + ")");
            }
        }

    /* 17. (*) Produce a single String that is the result of concatenating the
    uppercase versions of all of the Strings. For example, the result should be
    "HIHELLO...". Use a single reduce operation, without using map.  */

        System.out.println("\n17.");
        String concat1 = words.stream()
            .reduce("", (sA, sB) -> sA + sB.toUpperCase());
        System.out.println(concat1);

    /* 18. (*) Produce the same String as above, but this time via a map operation that
     turns the words into upper case, followed by a reduce operation that
     concatenates them.  */

        System.out.println("\n18.");
        String concat2 = words.stream()
            .map(String::toUpperCase)
            .reduce("", (sA, sB) -> sA + sB);
        System.out.println(concat2);

    /* 19. (*) Produce a String that is all the words concatenated together, but
    with commas in between. For example, the result should be "hi,hello,...".
    Note that there is no comma at the beginning, before "hi", and also no comma
    at the end, after the last word.  */

        System.out.println("\n19.");
        String concat3 = words.stream().collect(Collectors.joining(","));
        System.out.println(concat3);


    }

    static List<Double> randomNumberList(int size) {
        return Stream.generate(new Random()::nextDouble)
            .limit(size)
            .collect(Collectors.toList());
    }

    static List<Integer> orderedNumberList(int start, int step, int size) {
        return Stream.iterate(start, n -> n + step)
            .limit(size)
            .collect(Collectors.toList());
    }

}