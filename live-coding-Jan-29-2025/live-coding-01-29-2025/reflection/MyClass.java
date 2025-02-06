package example;

public class MyClass {
    private final String a;
    private final String b;

    public MyClass(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "a = " + a + " and b = " + b;
    }
}
