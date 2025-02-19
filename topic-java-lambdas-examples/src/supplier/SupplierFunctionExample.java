package supplier;

import java.util.Date;
import java.util.function.Supplier;

/*
 * getSystemDate() is a static method which simply returns the current system date and does not take any input.
 * The method signature matches the function descriptor of Supplier i.e. () -> T .
 * In the main() method we have shown how to instantiate a Supplier interface instance in following three ways –
 *
 * 1. Using a Lambda Expression:
 * we have defined a a lambda expression which takes no input and returns a new String object with value set to “hello”.
 * This lambda is then assigned to a Supplier<String> instance named helloStrSupplier.
 * Invoking functional method get() on helloStrSupplier results in a String helloStr which is then printed to show
 * that it indeed contains the value “hello”.
 *
 * 2. Using a Method Reference to default constructor of String:
 * we create a Supplier<String> instance named emptyStrSupplier.
 * emptyStrSupplier is then used to create a String object named emptyStr using the get() method.
 * emptyStr‘s value is then printed to show its value is empty as defined.
 *
 * 3. Using a Method Reference to getSystemDate():
 * The getSystemDate() method of SupplierFunctionExample class is used to create a Supplier<Date> instance
 * named dateSupplier.
 * dateStrSupplier is then used to create a Date object named systemDate by invoking get() method on it.
 * systemDate‘s value is then printed to show its value.
 */
public class SupplierFunctionExample {
    public static void main(String[] args) {
        //Supplier instance with lambda expression
        Supplier<String> helloStrSupplier = () -> "Hello";
        String helloStr = helloStrSupplier.get();
        System.out.println("String in helloStr is->" + helloStr + "<-");

        //Supplier instance using method reference to default constructor
        Supplier<String> emptyStrSupplier = String::new;
        String emptyStr = emptyStrSupplier.get();
        System.out.println("String in emptyStr is->" + emptyStr + "<-");

        //Supplier instance using method reference to a static method
        Supplier<Date> dateSupplier = SupplierFunctionExample::getSystemDate;
        Date systemDate = dateSupplier.get();
        System.out.println("systemDate->" + systemDate);
    }

    public static Date getSystemDate() {
        return new Date();
    }
}
