package reflection.question1;

public class Driver {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(new InterfaceConstructor(args[0]));
        }
    }
}