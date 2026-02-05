package factory.demo;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> people = List.of("Fred", "Betty", "James"); // inbuilt factory method
        System.out.println(people.getClass()); // What type of list did we get?
    }
}
