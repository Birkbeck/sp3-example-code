package exampletwo;

// Create a method which takes a lambda expression as a parameter
public class Main {
    public static void main(String... args) {
        StringFunction ouch = s -> s + "!";
        StringFunction ask = s -> s + "?";
        formatted("hello", ouch);
        formatted("Hello", ask);
    }

    public static void formatted(String str, StringFunction func){
        System.out.println(func.run(str));
    }
}

@FunctionalInterface
interface StringFunction {
    String run(String str);
    default void anotherMethod() {} // still a single abstract method SAM
    default void anotherMethod2() {} // still a single abstract method SAM
    //void anotherMethod3();
}
