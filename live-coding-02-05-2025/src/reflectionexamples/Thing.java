package reflectionexamples;

import java.lang.reflect.InvocationTargetException;

public class Thing {
    public static void main(String... args) throws ClassNotFoundException {
        A aaaaaa = new AClass();
//        Class<?> c1 = String.class;
//        for (var m: c1.getDeclaredMethods()){
//            System.out.println(m);
//        }
//        System.out.println(c1.getName());
        Class<?> c1 = Class.forName("reflectionexamples.AClass");
//        Arrays.stream(c1.getDeclaredMethods()).map(Method::getReturnType).forEach(System.out::println);
//        Arrays.stream(c1.getDeclaredConstructors()).forEach(System.out::println);
//        Arrays.stream(c1.getDeclaredFields()).forEach(System.out::println);
        try {
            AClass aaa = (AClass) c1.getDeclaredConstructor().newInstance();
            System.out.println(aaa);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
