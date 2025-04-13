package covariant;

import java.util.ArrayList;
import java.util.List;

public class CovariantGenericsExampleTwo {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        List<? extends Number> numbers = integers;
        Double d = 23.0;
        //numbers.add(d);
    }
}
