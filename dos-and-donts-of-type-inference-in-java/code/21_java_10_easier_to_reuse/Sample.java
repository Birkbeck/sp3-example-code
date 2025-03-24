import java.util.*;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

class Person {
    private final String name;
    private final int age;

    public Person(String theName, int theAge) {
        name = theName;
        age = theAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return String.format("%s -- %d", name, age);
    }
}

public class Sample {
    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", 20),
                new Person("Sara", 22),
                new Person("Bob", 20),
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 2),
                new Person("Jack", 72),
                new Person("Jill", 12)
        );
    }

    public static void main(String[] args) {
        //Collector<Person, ?, Map<Integer, Set<String>>> groupByAgeMapToName =

        var groupByAgeMapToName =
                groupingBy(Person::getAge, mapping(Person::getName, toSet()));

        var namesByAge1 =
                createPeople().stream()
                        .collect(groupByAgeMapToName);

        var namesByAge2 =
                createPeople().stream() //this may be on a different collection, for example
                        .collect(groupByAgeMapToName);

        System.out.println(namesByAge1);
        System.out.println(namesByAge2);
    }
}