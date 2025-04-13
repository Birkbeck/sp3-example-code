package abstractclasses;

import java.time.LocalDate;

public class Employee extends Person {

    private double salary;
    private final LocalDate hireDay;

    public Employee(String firstName, String lastName, int age, double salary, int year, int month, int day) {
        super(lastName + ", " + firstName, age);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String getInfo() {
        return "an employee with a salary of $%.2f".formatted(salary) + " and hire day of " + hireDay;
    }

    public void raiseSalary(double byPercent) {
        this.salary += byPercent * this.salary;
    }
}
