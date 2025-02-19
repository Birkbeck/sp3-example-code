package comparator;

import java.util.Arrays;
import java.util.Comparator;

public class HigherOrderDemo {
    public static Comparator<String> compareInDirecton(int direction) {

        return (x, y) -> direction * x.compareTo(y);
    }

    public static Comparator<String> reverse(Comparator<String> comp) {

        return (x, y) -> -comp.compare(x, y);
    }

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};

//    Arrays.sort(words);
//    System.out.println(Arrays.toString(words));

//    Arrays.sort(words, compareInDirecton(-1));
//    System.out.println(Arrays.toString(words));

        Arrays.sort(words, reverse(String::compareToIgnoreCase));
        System.out.println(Arrays.toString(words));
    }
}
