package recursion;

import static recursion.TailCalls.call;
import static recursion.TailCalls.done;

public class Factorial {
    public static int factorialRec(final int number) {
        if (number == 1)
            return number;
        else
            return number * factorialRec(number - 1);
    }

    public static TailCall<Integer> factorialTailRec(
            final int factorial, final int number) {
        if (number == 1)
            return done(factorial);
        else
            return call(() -> factorialTailRec(factorial * number, number - 1));
    }

    public static int factorial(final int number) {
        return factorialTailRec(1, number).invoke();
    }

    public static void main(final String[] args) {
        System.out.println("//" + "START:FACTREC_DISPLAY_5_OUTPUT");
        System.out.println(factorialRec(5));
        System.out.println("//" + "END:FACTREC_DISPLAY_5_OUTPUT");

        System.out.println("//" + "START:FACTREC_DISPLAY_LARGE_OUTPUT");
        try {
            System.out.println(factorialRec(20000));
        } catch (StackOverflowError ex) {
            System.out.println(ex);
        }
        System.out.println("//" + "END:FACTREC_DISPLAY_LARGE_OUTPUT");

        System.out.println("//" + "START:FACTTAILREC_DISPLAY_5_OUTPUT");
        System.out.println(factorialTailRec(1, 5).invoke());
        System.out.println("//" + "END:FACTTAILREC_DISPLAY_5_OUTPUT");

        System.out.println("//" + "START:FACTTAILREC_DISPLAY_LARGE_OUTPUT");
        System.out.println(factorialTailRec(1, 20000).invoke());
        System.out.println("//" + "END:FACTTAILREC_DISPLAY_LARGE_OUTPUT");


        System.out.println("//" + "START:FACTORIAL_DISPLAY_OUTPUT");
        System.out.println(factorial(5));
        System.out.println(factorial(20000));
        System.out.println("//" + "END:FACTORIAL_DISPLAY_OUTPUT");

    }
}
