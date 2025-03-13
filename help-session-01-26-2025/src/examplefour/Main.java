package examplefour;

public class Main {
    public static void main(String[] args) {
        GenericInterface<Integer> factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++){
                result*= i;
            }
            return result;
        };
        
        System.out.println("Factorial of 10 = " + factorial.func(10));
    }    
}

@FunctionalInterface
interface GenericInterface<T> {
    T func(T t);
}
