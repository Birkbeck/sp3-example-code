package multipleinheritance;

public class Main {
    public static void main(String... args) {
        C cObj = new C();
        cObj.printUsingA();
        cObj.printUsingB();
        cObj.anotherMethod();
    }
}
