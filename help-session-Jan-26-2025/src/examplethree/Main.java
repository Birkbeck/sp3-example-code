package examplethree;

public class Main {
    public static void main(String[] args) {
        GenericInterface<String> reverse = str -> {
            String result = "";
            for (int i = str.length()-1; i >= 0; i--){
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Reversed using lambda: " + reverse.func("A String"));
    }
}

@FunctionalInterface
interface GenericInterface<T> {
    T func(T t);
}