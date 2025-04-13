package functionalinterfaces;

public class CustomInterfacePrinter {
    public static void main(String[] args) {
        CustomInterfacePrinter printer = new CustomInterfacePrinter();
        printer.print((String param) -> {
            System.out.println("My lambda says " + param);
        });
    }

    public void print(CustomFunctionalInterface firstInterface) {
        firstInterface.singleMethod("apple");
    }
}
