import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Outline {
  public static void main(String... args) { // varargs alternative to String[]

    String[] words = {"fly","ants","bats","piglets","gorillas","cat","hamster","emus","tiger" };

    /*
    Create an array containing some Strings. Sort the array by
    1. length (i.e., shortest to longest)
    2. reverse length (i.e., longest to shortest)
    3. first character
    4. Strings that contain "e" first, everything else second.
     */

    // 1.1. shortest to longest
    System.out.println("1.1");
    Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
    System.out.println(Arrays.asList(words));

    // 1.2. longest to shortest
    System.out.println("1.2");
    Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
    System.out.println(Arrays.asList(words));

    // 1.3. first characters
    System.out.println("1.3");
    Arrays.sort(words, (a, b) -> Character.compare(a.charAt(1), b.charAt(1)));
    System.out.println(Arrays.asList(words));

    // 1.4. strings containing e - Lambda
    System.out.println("1.4");
    Arrays.sort(words, (a, b) -> a.contains("e") ? -1 : 0);
    System.out.println(Arrays.asList(words));

    // Rewrite the final lambda sorting example, but use a method reference in place of an explicit lambda.
    // 1.4b. strings containing e - Method Reference
    System.out.println("1.4b");
    Arrays.sort(words, StringUtils::eChecker);
    System.out.println(Arrays.asList(words));

    // 2
    // Create a class with a static method called betterString which should take two Strings
    // and a lambda as its arguments;
    System.out.println("2.");
    String test1 = "gorillas";
    String test2 = "emus and turkeys";
    System.out.println(StringUtils.betterString(test1, test2, (s1, s2) -> s1.length() > s2.length()));
    System.out.println(StringUtils.betterString(test1, test2, (s1, s2) -> true));

    // 3
    // Use generics to replace betterString with betterEntry and to
    // replace TwoStringPredicate with TwoElementPredicate.
    System.out.println("3.");
    System.out.println(StringUtils.betterElement(test1, test2, (s1, s2) -> s1.length() > s2.length()));
    System.out.println(StringUtils.betterElement(test1, test2, (s1, s2) -> true));
    int i1 = 3;
    int i2 = 455;
    System.out.println(StringUtils.betterElement(i1, i2, (s1, s2) -> s1 > s2));
    System.out.println(StringUtils.betterElement(i1, i2, (s1, s2) -> true));

    // 4
    // Create a static method called allMatches. It should take a List of Strings and a
    // Predicate<String>, and return a new List of all the values that passed the test.
    System.out.println("4.");
    List<String> wordlst = new ArrayList<>(Arrays.asList(words));
    /*
    List<String> shortWords = StringUtils.oAllMatches(wordlst, s -> s.length() < 4);
    System.out.println(shortWords);
    List<String> wordsWithB = StringUtils.oAllMatches(wordlst, s -> s.contains("b"));
    System.out.println(wordsWithB);
    List<String> evenLengthWords = StringUtils.oAllMatches(wordlst, s -> (s.length() % 2) == 0);
    System.out.println(evenLengthWords);
     */

    // 5
    // Rewrite allMatches so it works on any List and associated Predicate,
    // not just on Strings. Verify that the examples from the previous question still work.

    System.out.println("5.");

    System.out.println(wordlst);

    List<String> shortWords = StringUtils.allMatches(wordlst, s -> s.length() < 4);
    System.out.println(shortWords);
    List<String> wordsWithB = StringUtils.allMatches(wordlst, s -> s.contains("b"));
    System.out.println(wordsWithB);
    List<String> evenLengthWords = StringUtils.allMatches(wordlst, s -> (s.length() % 2) == 0);
    System.out.println(evenLengthWords);

    List<Integer> integerList = new ArrayList<>(Arrays.asList(2, 34, 55, 345, 57, 243, 24));

    List<Integer> evenIntegers = StringUtils.allMatches(integerList, n -> (n % 2) == 0);
    System.out.println(evenIntegers);

    // 6
    // Create a static method called transformedList. It should take a List of Strings and a
    // Function<String,String> and return a new List that contains the results of applying the
    // function to each element of the original list.
    System.out.println("6.");

    /*
    List<String> excitingWords = StringUtils.oTransformedList(wordlst, s -> s + "!");
    System.out.println(excitingWords);
    List<String> eyeWords = StringUtils.oTransformedList(wordlst, s -> s.replace("i", "eye"));
    System.out.println(eyeWords);
    List<String> upperCaseWords = StringUtils.oTransformedList(wordlst, String::toUpperCase);
    System.out.println(upperCaseWords);

    List<Integer> multiIntegers = StringUtils.oTransformedList(integerList, n -> n * 2);
    System.out.println(multiIntegers);

     */

    // 7
    // Rewrite transformedList so it works with generic types.
    System.out.println("7.");
    List<String> excitingWords = StringUtils.transformedList(wordlst, s -> s + "!");
    System.out.println(excitingWords);
    List<String> eyeWords = StringUtils.transformedList(wordlst, s -> s.replace("i", "eye"));
    System.out.println(eyeWords);
    List<String> upperCaseWords = StringUtils.transformedList(wordlst, String::toUpperCase);
    System.out.println(upperCaseWords);

    List<Integer> multiIntegers = StringUtils.transformedList(integerList, n -> n * 2);
    System.out.println(multiIntegers);
  }
}
