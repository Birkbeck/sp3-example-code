package samtwo;

public class SamMain {
    public static void main(String[] args) {
        MyInterface myInterface = (String text) -> {
            System.out.println(text);
        };
        myInterface.printIt("As a result of the lambda expression");
        MyInterface.printItToSystemOut("From static method");
    }
}
