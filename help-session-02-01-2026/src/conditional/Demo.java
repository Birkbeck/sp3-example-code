package conditional;

import java.util.List;
import java.util.stream.Stream;

public class Demo {
    static void main() {
        List<String> rawData = List.of("abced", "10", "calling", "20", "e", "fish", "50", "help");
        System.out.println(rawData);
        List<Integer> validNumbers = rawData.stream()
                .flatMap(s -> {
                    System.err.println("Validating " + s);
                            try {
                                return Stream.of(Integer.parseInt(s));
                            } catch (NumberFormatException e) {
                                return Stream.empty();
                            }
                        }
                )
                .toList();
        System.out.println();
        System.out.println(validNumbers);
    }

}
