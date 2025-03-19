package multipleinheritance;

public interface A {
    default void printUsingA() {
        System.out.println("Print from A");
    }

    default void anotherMethod() {
    }
}