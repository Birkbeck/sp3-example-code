package demos;

import java.util.ArrayList;

public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Paul");
        names.add("Mary");
        Employee[] employees = names.stream().map(Employee::new).toArray(Employee[]::new);
        for (Employee e : employees)
            System.out.println(e.getName());
    }
}
