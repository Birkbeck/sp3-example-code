package reflection;

import java.lang.reflect.Method;

class Calculator {
    public void add(int a, int b) {
        System.out.println("Result: " + (a + b));
    }
}

public class DynamicRunner {
    public static void main(String... args) throws Exception {
        Object calc = new Calculator();
        String methodName = "add"; // This could come from a config file

        // Find the method by name and parameter types
        Method method = calc.getClass().getMethod(methodName, int.class, int.class);

        // Invoke the method: (object instance, arguments...)
        method.invoke(calc, 10, 20); // Outputs: Result: 30
    }
}