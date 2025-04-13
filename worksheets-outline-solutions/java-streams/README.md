# Worksheet Three

## The Stream Processing API

+ This worksheet examines your existing knowledge to reinforce concepts from your previous studies.
+ It is essential that you commit regularly any changes to your source code (to the respective `GitHub Classroom`
  repository).
+ Where the questions make incremental changes to the code you **do not** need to keep separate versions of your code,
  as your commits will deal with that situation.
+ Text based questions should be answered inline by modifying this document.

## Learning goals

Before the next session, you should try to achieved the following learning goals:

+ Use the `stream` api to process a list.
+ Use streams to achieve *lazy* evaluation.
+ Have seen examples of the basic functional operations: *filter*, *map*, *reduce*, etc.
+ Compare *parallel* and *serial* execution using the `stream` api.

Remember that **starred** exercises are more difficult.
Do not attempt starred exercises unless the other exercises are clear to you.

## Preamble

The `Arrays` class provides a number of static utility methods for manipulating arrays. For example, to print out an
array, consider using `Arrays.asList`.

The point of this is that if you just print an array directly, you do not see anything useful (just the type and memory
address), but if you print a `List`,
it shows the individual elements separated by commas (it is simpler than creating a loop to traverse the array and print
out the elements).

The following exercises presume that you have a main class containing an array which you then pass to the `Arrays.sort`
method. For example, initially the class might look something like the following:

```java
import java.util.Arrays;

public class Outline {
  public static void main(String... args) { // varargs alternative to String[]
    Integer[] intArray = {1,7,3,4,8,2};
    System.out.println(Arrays.asList(intArray));
    // Arrays.sort(intArray,.......)
  } 
}
```

## The Exercises

The following questions use the `Dish` class from the repository.

1. How would you use streams to filter the first two meat dishes?

2. How would you count the number of dishes in a stream using the `map` and `reduce` methods?
   The next group of questions refer to a list of numbers.

3. Given a list of numbers, how would you return a list of the square of each number?
   For example, given `[1, 2, 3, 4, 5]` you should return `[1, 4, 9, 16, 25]`.

4. Given two lists of numbers, how would you return all pairs of numbers? For example, given a list `[1, 2, 3]` and a
   list `[3, 4]` you should return:

   ```java
   [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
   ```
   For simplicity, you can represent a *pair* `(x,y)` as an array with two elements.

5. How would you extend the previous example to return only pairs whose sum is divisible by `3`? For example, `(2, 4)`
   and `(3, 3)` are valid.
   <br/>All the remaining questions should be answered using the new Java 8 *Streams*.
   For all the exercises, start with a `List` of `String`s similar to this:

   ```java
   List<String> words = Arrays.asList("hi", "hello", ...);
   ```

6. Loop through the words and print each one on a separate line, with two spaces in front of each word.

7. Repeat this problem but **without** two spaces in front of each word.
   This should be trivial if you use the same approach as the previous question; the point here is to make use of a **
   method reference**.

8. For the following expressions, from the earlier questions, produce the same transformations using `map`:
    + `List<String> excitingWords = transformedList(words, s -> s + "!");`
        + `List<String> eyeWords = transformedList(words, s -> s.replace("i", "eye"));`
        + `List<String> upperCaseWords = transformedList(words, String::toUpperCase);`

9. For the following lists produce the same transformations using `filter` (you wrote solutions for the earlier
   questions):
    + `List<String> shortWords = allMatches(words, s -> s.length() < 4);`
    + `List<String> wordsWithB = allMatches(words, s -> s.contains("b"));`
    + `List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);`

10. (*) Turn the strings in the array `words` into uppercase, keep only the ones that are shorter than four characters,
    and, of what is remaining, keep only the ones that contain `"e"`, and print the first result.
    Repeat the process, except checking for a `"q"` instead of an `"e"`.
11. (** ) The above example uses *lazy* evaluation, but it is not easy to see that it is doing so. Create a variation of
    the above example that shows that it is doing lazy evaluation. The simplest way is to track which entries are turned
    into upper case.

15. (*) Write a `static` method that produces a `List` of a specified length of random numbers. For example,
    ```java
    List<Double> nums = randomNumberList(someSize);
    
	// Result is something like [0.7096867136897776, 0.09894202723079482, ...]
    ```
16. (*) Write a `static` method that produces a list of numbers that go in order by a step size. For example,
    ```java
    List<Integer> nums = orderedNumberList(50, 5, someSize);
    
    // Result is [50, 55, 60, ...]
    ```
17. (*) Provide three ways to use streams to compute the sum of a list of numbers.
18. (*) Rewrite one of the solutions from the previous question so that it can be executed in parallel; verify that you
    get the same answer as for the sequential code.
19. (** ) Now, use streams to compute the product of some doubles. Show that the *serial* and *parallel* versions **do
    not** always result in the same answer.

    **Note:**

    This is a bit tricky, because it seems at first that multiplication is associative, as required by the
    parallel `reduce`.
    Also, it will be impossible to have differing results if you have a single-core computer!

12. (*) Produce a single `String` that is the result of concatenating the uppercase versions of all of the `String`s.
    For example, the result should be `"HIHELLO..."`.
    Use a single `reduce` operation, without using `map`.
13. (*) Produce the same `String` as above, but this time via a `map` operation that turns the words into upper case,
    followed by a `reduce` operation that concatenates them.
14. (*) Produce a `String` that is all the words concatenated together, but with commas in between.
    For example, the result should be `"hi,hello,..."`. Note that there is no comma at the beginning, before `"hi"`, and
    also no comma at the end, after the last word.