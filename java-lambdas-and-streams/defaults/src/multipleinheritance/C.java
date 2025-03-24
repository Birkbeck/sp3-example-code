package multipleinheritance;

public class C implements A, B {
    public static void main(String... args) {
        C cObj = new C();
        cObj.printUsingA();
        cObj.printUsingB();
        cObj.anotherMethod();
    }

    public void anotherMethod() {
        B.super.anotherMethod();
    }
}