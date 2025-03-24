package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Function instance funcEmpToString maps\converts an Employee object to a String of his\her name.
 * Employee list is passed to the method applyIdentityToEmpList() along with an instance of Function.identity().
 * The parameter of applyIdentityToEmpList() which takes Function.identity() value is nothing but
 * Function<Employee, Employee> i.e. an equivalent of a Function which takes Employee as input and returns
 * (the same) Employee as output.
 * Method applyIdentityToEmpList() takes the input employee list, iterates through it,
 * applies the identity() function to each employee in the list and returns the list of employees obtained by
 * applying the identity() function.
 * So, we can see that the identity function does nothing, it just returns the object it receives as input.
 * So, what we get back is the same employee list which we passed to the applyIdentityToEmpList() method!
 * And the same i.e. original employee list is printed as output!!
 * This is how the static method Function.identity() works.
 */
public class FunctionTRIdentityExample {
    public static void main(String[] args) {
        Function<Employee, String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };
        List<Employee> employeeList = Util.load();
        List<Employee> empNameListInitials = applyIdentityToEmpList(employeeList, Function.identity());
        empNameListInitials.forEach(System.out::println);
    }

    public static List<Employee> applyIdentityToEmpList(List<Employee> employeeList, Function<Employee, Employee> funcEmpToEmp) {
        List<Employee> empNameList = new ArrayList<Employee>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToEmp.apply(emp));
        }
        return empNameList;
    }
}