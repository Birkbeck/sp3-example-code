package reflection;

import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String... args) throws Exception {
        // Obtain the class object
        Class<?> clazz = String.class;

        System.out.println("Class Name: " + clazz.getName());
        System.out.println("Superclass: " + clazz.getSuperclass().getName());

        // List all public methods
        Method[] methods = clazz.getMethods();
        System.out.println("Number of public methods: " + methods.length);
    }
}