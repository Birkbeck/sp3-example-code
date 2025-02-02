package optional;

import java.util.stream.Stream;

public class OrElseThrowExampleTwo {
    public static void main(String[] args) {
        String result = Stream.of("outlet", "puddle", "eraser")
                .filter(s -> Character.isAlphabetic(s.charAt(0)))
                .findAny()
                .orElseThrow();
        System.out.println(result);
    }
}
