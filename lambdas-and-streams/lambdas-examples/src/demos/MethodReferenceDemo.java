package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        String[] strings = {"Mary", "had", "a", "little", "lamb"};
        Arrays.sort(strings, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(strings));
        // [a, had, lamb, little, Mary]

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));
        list.removeIf(Objects::isNull);
        list.forEach(System.out::println);
        // Malfoyå
        // Crabbe
        // Goyle
    }
}
