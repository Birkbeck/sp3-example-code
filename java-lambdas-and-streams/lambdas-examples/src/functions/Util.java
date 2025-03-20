package functions;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<Employee> load() {
        return Arrays.asList(new Employee("Tom Jones", 45),
            new Employee("Harry Major", 25),
            new Employee("Ethan Hardy", 65),
            new Employee("Nancy Smith", 15),
            new Employee("Deborah Sprightly", 29));
    }
}
