package capture;

public class Main {
    public static void main(String[] args) {
        MyFactory myFactory = chars -> new String(chars);

        String myString = "Test";

        myFactory = chars -> myString + ":" + new String(chars);
    }
}
