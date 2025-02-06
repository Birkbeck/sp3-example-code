package abstractclasses;

public class Main {
    public static void main(String... args) {
        var people = new Person[2];
        people[0] = new Employee("Bart", "Simpson", 13, 50_000, 1989, 10, 1);
        people[1] = new Student("Gordon", "Philips", 34, "Maths");

        for (var p : people) {
            System.out.println(p);
            System.out.println(p.getName() + " " + p.getInfo());
        }
    }
}
