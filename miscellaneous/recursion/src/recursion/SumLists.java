package recursion;

import java.util.List;

/**
 * Tail recursive version of a sum lists method
 */
public class SumLists {
    public static int sumList(List<Integer> ls) {
        if (ls.isEmpty()) {
            return 0;
        } else {
            return sumListHelper(ls, 0);
        }
    }

    private static int sumListHelper(List<Integer> ls, int acc) {
        if (ls.isEmpty()) {
            return acc;
        } else {
            return sumListHelper(tail(ls), ls.get(0) + acc);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumList(List.of(1, 2, 3, 4, 5)));
        System.out.println(sumList(List.of(1, 2, 3, 4, -5, 6, 7, 8, 9, 10)));
    }

    public static <T> List<T> tail(List<T> xs)
        throws IndexOutOfBoundsException, IllegalArgumentException {
        return xs.subList(1, xs.size());
    }
}
