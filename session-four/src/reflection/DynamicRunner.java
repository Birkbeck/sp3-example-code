package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

class Calculator {
    public void add(int a, int b) {
        System.out.println("Result: a + b = " + (a + b));
    }

    public void subtract(int a, int b) {
        System.out.println("Result: a - b = " + (a - b));
    }
}

public class DynamicRunner {
    public static void main(String... args) {
        var calc = new Calculator();
        System.out.println("Calculator: " + calc.getClass());

        var scanner = new Scanner(System.in);
        System.out.print("Enter operation: ");
        String methodName = scanner.nextLine();
        scanner.close();
        System.out.println("Operation: " + methodName);

        // Find the method by name and parameter types
        Method method = null;
        try {
            method = calc.getClass().getMethod(methodName, int.class, int.class);
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + methodName);
            System.exit(-1);
        }

        // Invoke the method: (object instance, arguments...)
        try {
            method.invoke(calc, 10, 20); // Outputs: Result: 30
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("Method invocation failed: " + e.getCause());
        }
    }
}