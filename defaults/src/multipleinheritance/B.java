package multipleinheritance;

import java.security.spec.RSAOtherPrimeInfo;

public interface B {
    default void printUsingB() {
        System.out.println("Print from B");
    }

    default void anotherMethod() {
        System.out.println("Another method");
    }
}