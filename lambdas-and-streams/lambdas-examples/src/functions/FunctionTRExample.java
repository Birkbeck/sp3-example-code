package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
 * funcEmpToString is an instance of Function<Employee,String>.
 * This is the java.util.function.Function instance which is used to convert/map from
 * an Employee object to a String value.
 * The lambda defining funcEmpToString is – (Employee e)-> {return e.getName();} .
 * It takes as input an Employee object and returns his\her name, which is a String value, as output.
 * The list of employees is passed to method convertEmpListToNamesList() along with the Function object funcEmpToString;
 * The method convertEmpListToNamesList() iterates over all the employees in the employee list,
 * applies the function funcEmpToString to each of the Employee objects,
 * getting back the employee names in String format, which it puts in a employee name list and
 * sends it back to the main() method.
 * On printing the employee name list we get the names of all the employees as required.
 */
public class FunctionTRExample {
    public static void main(String[] args) {
        Function<Employee, String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };

        List<Employee> employeeList = Util.load();
        List<String> empNameList = convertEmpListToNamesList(employeeList, funcEmpToString);
        empNameList.forEach(System.out::println);
    }

    // Example of a "Higher-order function" (HoF) --- a function (method) that takes another function (method) as an argument.
    public static List<String> convertEmpListToNamesList(List<Employee> employeeList,
                                                         Function<Employee, String> fETS) {
        List<String> empNameList = new ArrayList<>();
        for (Employee emp : employeeList) {
            empNameList.add(fETS.apply(emp)); // fETS(emp)
        }
        return empNameList;
    }
}
