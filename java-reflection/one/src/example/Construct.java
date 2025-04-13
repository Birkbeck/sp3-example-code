package example;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Construct {
    public static void main(String[] args) {
        Class c;
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.print("The name of the class: ");
            var aclass = sc.next();
            c = Class.forName(aclass);

            // var constructors = c.getConstructor(null);
            // For a constructor that required two Strings one could
            // specify it in the following manner: (one of many approaches)
            var css = c.getConstructor(
                    String.class, String.class);
            // So, the "trick" is to form a "Class" array and populate it
            // with the types you require.

            var obj = css.newInstance("x", "y");
            // This will call the constructor with two String args and
            // provide values "x" and "y" for those strings.
            System.out.println(obj);
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not find the class");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
    }

    @Override
    public String toString() {
        return "XXXXX";
    }
}
