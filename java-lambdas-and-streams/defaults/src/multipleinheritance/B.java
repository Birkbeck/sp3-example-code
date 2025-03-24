package multipleinheritance;

public interface B {
    default void printUsingB() {
        System.out.println("Print from B");
    }

    default void anotherMethod() {
    }
}