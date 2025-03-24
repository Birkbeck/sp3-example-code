package example;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Introspect {
    public static void main(String[] args) {
        Class c;
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.print("The name of the class: ");
            var aclass = sc.next();
            c = Class.forName(aclass);
            System.out.println(c.getName());
            System.out.println(c.getSimpleName());
            System.out.println(c.isInterface());
            Method[] meth = c.getMethods();
            for (var m : meth) {
                System.out.println(m);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not find the class");
        } finally {
            sc.close();
        }
    }
}
