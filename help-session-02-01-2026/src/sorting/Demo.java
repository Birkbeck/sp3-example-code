package sorting;

import java.util.Comparator;
import java.util.List;

// Multi-level sorting

public class Demo {
    static void main() {
        List<User> users = new java.util.ArrayList<>(List.of(new User("Fred", "Bloggs")
                , new User("John", "Lennon")
                , new User("Frank", "Zappa")
                , new User("John", "Doe")
                , new User("Jane", "Doe")
                , new User("Barney", "Rubble")));
        System.out.println("Users: " + users);

        users.sort(
                Comparator.comparing(User::LastName)
                        .thenComparing(User::FirstName)
                        .reversed()
        );
        System.out.println();
        System.out.println("Result: " + users);
    }
}

record User(String FirstName, String LastName) {
}
