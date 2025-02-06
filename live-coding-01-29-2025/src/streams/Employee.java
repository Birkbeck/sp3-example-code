package streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public void salaryIncrement(Double percentage) {
        Double newSalary = salary + percentage * salary / 100;
        setSalary(newSalary);
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name:" + name + " Price:" + salary;
    }
}