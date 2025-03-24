package recursion;

// Fast exponentiation is a technique to optimize the exponentiation of numbers:
// b^2n = (b^2)^n = (b^n)^2
// b^(2n + 1) = b * b^(2n)
//

public class FastExp {
    public static int fastExp(int base, int exp) {
        if (exp == 0) {
            return 1;
        } else if ((exp % 2) != 0) {
            return base * fastExp(base, exp - 1);
        } else {
            return fastExp(base * base, exp / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fastExp(2, 3));
        System.out.println(fastExp(5, 5));
    }
}
