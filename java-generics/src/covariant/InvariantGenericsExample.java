package covariant;

import java.util.ArrayList;
import java.util.List;

public class InvariantGenericsExample {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        // numbers = integers;
    }
}
