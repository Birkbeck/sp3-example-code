package abstractclasses;

public class Student extends Person {
    private String course;

    public Student(String firstName, String lastName, int age, String course) {
        super(lastName + ", " + firstName, age);
        this.course = course;
    }
    @Override
    public String getInfo() {
        return "a student majoring in " + course;
    }
}
