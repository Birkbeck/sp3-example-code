package multipleinheritance;

public class C implements A, B {

    public void anotherMethod() {
        B.super.anotherMethod();
    }
}