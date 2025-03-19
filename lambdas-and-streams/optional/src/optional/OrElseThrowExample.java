package optional;

import java.util.stream.Stream;

public class OrElseThrowExample {
    public static void main(String[] args) {
        String result = Stream.of("outlet", "puddle", "eraser")
            .filter(s -> Character.isDigit(s.charAt(0)))
            .findAny()
            .orElseThrow();
        System.out.println(result);
    }
}
