package reflectionexamples;

public class Main {
    public static void main(String... args) {
        A a = new AClass(1.2f, 5);
        Class<?> cl = a.getClass(); // AClass.class
        //System.out.println(a);
        //System.out.println(a.getClass());
        //System.out.println(a.getClass().isEnum());
        //System.out.println(a.getClass().getPackageName());
//        Constructor<?>[] cons = cl.getConstructors();
//        Arrays.stream(cons).forEach(System.out::println);
//        Method[] m = cl.getDeclaredMethods();
//        Arrays.stream(m).forEach(System.out::println);
//        Method[] m2 = cl.getMethods();
//        Arrays.stream(m2).forEach(System.out::println);
//        Field[] fl = cl.getDeclaredFields();
//        Arrays.stream(fl).forEach(System.out::println);
        System.out.println(AClass.class.getSuperclass());
    }
}
