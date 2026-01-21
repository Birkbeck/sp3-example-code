package lambda;

import java.util.function.Predicate;

public class DemoThree {
    static void main() {
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithZ = s -> s.endsWith("Z");

        Predicate<String> both = startsWithA.and(endsWithZ);

        System.out.println(both.test("AMMMMMMMMMMMMDDDZ"));
        System.out.println(both.test("AMMMMMMM"));
        System.out.println(both.test("MMMMMMZ"));
    }
}
