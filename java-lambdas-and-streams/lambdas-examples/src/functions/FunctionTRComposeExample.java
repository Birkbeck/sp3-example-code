package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Function instance funcEmpToString maps\converts an Employee object to a String value of his\her name.
 * Function instance funcEmpFirstName maps\converts the name inside an Employee object to the first name
 * using the substring method of String.
 * Default method compose() is used to combine funcEmpFirstName with funcEmpToStringString.
 * What the combined method does is that it first converts the name of an Employee into just his\her
 * first name returning the same Employee object back with the changed value of name.
 * It then converts\maps the Employee object to just its name as a String.This combined function
 * is passed as Function<Employee, String> parameter to convertEmpListToNamesList() method along
 * with the employee list.
 * When the convertEmpListToNamesList() applies the combined function to each of the Employee objects,
 * then the result is the list of first names of each employee.
 */
public class FunctionTRComposeExample {
    public static void main(String[] args) {
        Function<Employee, String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };
        Function<Employee, Employee> funcEmpFirstName =
            (Employee e) -> {
                int index = e.getName().indexOf(" ");
                String firstName = e.getName().substring(0, index);
                e.setName(firstName);
                return e;
            };
        List<Employee> employeeList = Util.load();
        List<String> empFirstNameList = convertEmpListToNamesList(employeeList, funcEmpToString.compose(funcEmpFirstName));
        empFirstNameList.forEach(str -> {
            System.out.print(" " + str);
        });
    }

    public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString) {
        List<String> empNameList = new ArrayList<>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }
}