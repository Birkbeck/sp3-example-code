package cpackage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    static void main() {
        List<Employee> employees = Arrays.asList(
                new Employee("Devin", "IT"),
                new Employee("Sarah", "HR"),
                new Employee("James", "IT"),
                new Employee("Erica", "Finance"));

        // Group by dept
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));
        byDept.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

record Employee(
        String name,
        String department) {
}

// Stream<List<Item>> -> Stream<Item> using flatMap