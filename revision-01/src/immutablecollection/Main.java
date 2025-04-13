package immutablecollection;

import java.util.List;

public class Main {
    public static void main(String... args) {
        List<String> initialSettings = List.of("a", "b", "c");
        Configuration config = new Configuration(initialSettings);
        System.out.println(config);
        try {
            config.getSettings().add("Oops");
        } catch (UnsupportedOperationException e) {
            System.out.println("You cannot modify the list");
        }
    }
}
