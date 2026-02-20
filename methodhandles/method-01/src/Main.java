import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static void main() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        System.out.printf("MethodHandles.lookup() = %s%n", lookup);
        MethodType mt = MethodType.methodType(List.class, Object[].class);
        System.out.printf("%s%n", mt);
         mt = MethodType.methodType(int.class, Object.class);
         System.out.printf("%s%n", mt);

         // for Methods
        mt = MethodType.methodType(String.class, String.class);
        MethodHandle concatMH = lookup.findVirtual(String.class, "concat", mt);
        System.out.printf("%s%n", concatMH);

        // Static Methods
        mt = MethodType.methodType(List.class, Object[].class);

        MethodHandle asListMH = lookup.findStatic(Arrays.class, "asList", mt);
        System.out.printf("%s%n", asListMH);

        // Constructors
        mt = MethodType.methodType(void.class, String.class);

        MethodHandle newIntegerMH = lookup.findConstructor(Integer.class, mt);
        System.out.printf("%s%n", newIntegerMH);

        MethodHandle getTitleMH = lookup.findGetter(Book.class, "title", String.class);
        System.out.printf("%s%n", getTitleMH);

        Method formatBookMethod = Book.class.getDeclaredMethod("formatBook");
        formatBookMethod.setAccessible(true);

        MethodHandle formatBookMH = lookup.unreflect(formatBookMethod);
        System.out.printf("%s%n", formatBookMH);

        mt = MethodType.methodType(String.class, char.class, char.class);
        MethodHandle replaceMH = lookup.findVirtual(String.class, "replace", mt);

        String output = (String) replaceMH.invoke("jovo", 'o', 'a');
        System.out.printf("%s%n", output);

        mt = MethodType.methodType(List.class, Object[].class);
        MethodHandle asList = lookup.findStatic(Arrays.class, "asList", mt);

        List<Integer> list;
        list = Collections.unmodifiableList((List<Integer>) asList.invokeWithArguments(1, 2));
        System.out.printf("%s%n", list);

        mt = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle sumMH = lookup.findStatic(Integer.class, "sum", mt);

        int sum = (int) sumMH.invokeExact(1, 11);
        System.out.printf("%s%n", sum);

        mt = MethodType.methodType(boolean.class, Object.class);
        MethodHandle equals = lookup.findVirtual(String.class, "equals", mt);

        MethodHandle methodHandle = equals.asSpreader(Object[].class, 2);
        System.out.printf("%s%n", methodHandle.invoke(new Object[] { "java", "java" }));

        mt = MethodType.methodType(String.class, String.class);
        concatMH = lookup.findVirtual(String.class, "concat", mt);

        MethodHandle bindedConcatMH = concatMH.bindTo("Hello ");
        System.out.printf("%s%n", bindedConcatMH.invoke("World!"));
    }
}
