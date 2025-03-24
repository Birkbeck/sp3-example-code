import java.util.*;

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
        //Map<Integer, List<Person>> peopleByAge =
        //Map<Integer, List<String>> namesByAge =
        //Map<Integer, Set<String>> namesByAge =

        var namesByAge =
                createPeople().stream()
                        //.collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
                        .collect(groupingBy(Person::getAge, mapping(Person::getName, toSet())));

        System.out.println(namesByAge);
    }
}