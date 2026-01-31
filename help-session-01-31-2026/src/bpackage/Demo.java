package bpackage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo {
    static void main() {
        List<String> emails = Arrays.asList("admin@tech.com", "user@gmail.com", "spam@junk.org");

        boolean hasJunk = emails.stream()
                .anyMatch(email -> email.endsWith(".org"));
        System.out.printf("hasJunk: %b%n", hasJunk);

        Optional<String> admin = emails.stream()
                .filter(email -> email.startsWith("admin"))
                .findFirst();

        admin.ifPresent(System.out::println);
    }
}
