package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    public static void main(String... args) throws Exception {
        // Obtain the class object
        Class<?> clazz = StringBuilder.class;

        System.out.println("Class Name (FQCN): " + clazz.getName());
        System.out.println("Class Name: " + clazz.getSimpleName());
        System.out.println("Superclass: " + clazz.getSuperclass().getName());
        System.out.println("SuperSuperclass: " + clazz.getSuperclass().getSuperclass().getName());
        System.out.println();

        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("Number of constructors: " + constructors.length);
        Arrays.stream(constructors).forEach(System.out::println);
        System.out.println();

        // List all public methods
        Method[] methods = clazz.getMethods();
        System.out.println("Number of public methods: " + methods.length);
        System.out.println("Number of public declared methods: " + clazz.getDeclaredMethods().length);
    }
}