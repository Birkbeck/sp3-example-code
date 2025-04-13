package lambdas;

import java.util.function.Predicate;

@FunctionalInterface
interface MyInterface {
    // could use a lambda here by assigning to a static field
    // or something similar
    Predicate<String> predStr = (x) -> true;

    //void myOtherMethod(); can't add this if we want to retain the "FunctionalInterface"
    static void myStaticMethod() {
    }

    void myMethod(); // SAM - Single Abstract Method

    default void myDefaultMethod() {
        helper();
    }

    private void helper() {
    }
}

public class Example {
    public static void main(String[] args) {
        Example ex = new Example();
        MyInterface myInt = new MyClass();
        myInt.myMethod();

        MyInterface my = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("In " + this.getClass().getName());
            }
        };

        my.myMethod();
        // In lambdas.MyClass
        // In lambdas.Example$1

        my = () -> {
            System.out.println("In lambda expression");
        };

        my.myMethod();
        // In lambdas.MyClass
        // In lambdas.Example$1
        // In lambda expression

        my = System.out::println;
        my.myMethod();
        // print a blank line

    }

    public void myMethodInExample(MyInterface myInt) {
        myInt.myMethod();
    }

}

class MyClass implements MyInterface {

    @Override
    public void myMethod() {
        System.out.println("In " + this.getClass().getName());
    }
}