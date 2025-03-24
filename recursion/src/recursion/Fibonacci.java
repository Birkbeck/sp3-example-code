package recursion;

// fib(n) = 1 | n = 0, 1
// fib(n) = fib(n - 1) + fib(n - 2) | otherwise

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        //System.out.println(fibonacci(Integer.MAX_VALUE));
    }
}
