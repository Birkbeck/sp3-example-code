package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * Function instance funcEmpToString maps\converts an Employee object to a String of his\her name.
 * Function instance initialFunction maps\converts a String to its initial or first letter.
 * Default method andThen() is used to combine initialFunction with funcEmpToString.
 * What the combined method does is that it first maps an Employee to his\her name and then takes out the
 * first letter from the name as a String value.
 * This combined function is passed as Function parameter to convertEmpListToNamesList()
 * method along with the employee list.
 * When the convertEmpListToNamesList() applies the combined function to each of the Employee objects,
 * then the result is a String list first letters of names of each employee.
 */

public class FunctionTRAndThenExample {
    public static void main(String[] args) {
        Function<Employee, String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };

        List<Employee> employeeList = Util.load();
        Function<String, String> initialFunction = (String s) -> s.substring(0, 1);
        List<String> empNameListInitials = convertEmpListToNamesList(employeeList,
            funcEmpToString.andThen(initialFunction));
        empNameListInitials.forEach(str -> {
            System.out.print(" " + str);
        });
    }

    public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString) {
        List<String> empNameList = new ArrayList<String>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }
}

