package streams;

import java.util.List;

public class EmployeeRepository {
    private List<Employee> empList = null;

    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;
    }

    public Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }
}
