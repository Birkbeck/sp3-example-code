package comparator;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        Person[] people = {new Person("George", "Washington"), new Person("John", "Adams"),
            new Person("Thomas", "Jefferson"), new Person("James", "Madison"), new Person("James", "Monroe"),
            new Person("John", "Quincy", "Adams"), new Person("Andrew", "Jackson"),
            new Person("Martin", "van Buren"), new Person("William", "Henry", "Harrison"),
            new Person("John", "Tyler"), new Person("James", "Knox", "Polk"), new Person("Zachary", "Taylor"),
            new Person("Millard", "Fillmore"), new Person("Franklin", "Pierce"), new Person("James", "Buchanan"),
            new Person("Abraham", "Lincoln"), new Person("Andrew", "Johnson"), new Person("Ulysses", "S.", "Grant"),
            new Person("Rutherford", "Birchard", "Hayes"), new Person("James", "Abram", "Garfield"),
            new Person("Grover", "Cleveland"), new Person("Benjamin", "Harrison"),
            new Person("Grover", "Cleveland"), new Person("William", "McKinley"),
            new Person("Theodore", "Roosevelt"), new Person("William", "Howard", "Taft"),
            new Person("Woodrow", "Wilson"), new Person("Warren", "Gamaliel", "Harding"),
            new Person("Calvin", "Coolidge"), new Person("Herbert", "Hoover"),
            new Person("Franklin", "Delano", "Roosevelt"), new Person("Harry", "S.", "Truman"),
            new Person("Dwight", "David", "Eisenhower"), new Person("John", "Fitzgerald", "Kennedy"),
            new Person("Lyndon", "Baines", "Johnson"), new Person("Richard", "Mulhouse", "Nixon"),
            new Person("Gerald", "Ford"), new Person("James", "Earl", "Carter"), new Person("Ronald", "Reagan"),
            new Person("George", "Herbert Walker", "Bush"), new Person("William", "Jefferson", "Clinton"),
            new Person("George", "Walker", "Bush"), new Person("Barack", "Hussein", "Obama")};

        Arrays.sort(people, Comparator.comparing(Person::getName));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, Comparator.comparing(Person::getName, (s, t) -> s.length() - t.length()));

        Arrays.sort(people, Comparator.comparingInt(p -> p.getName().length()));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, comparing(Person::getMiddleName, nullsFirst(naturalOrder())));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, comparing(Person::getName, reverseOrder()));
        System.out.println(Arrays.toString(people));
    }
}
