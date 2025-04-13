import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        System.out.println(
                numbers.stream()
                        .reduce(0, (Integer total, Integer e) -> total + e));

        System.out.println(
                numbers.stream()
                        //.reduce(0, (var total, Integer e) -> total + e)); //ERROR
                        //.reduce(0, (Integer total, var e) -> total + e)); //ERROR
                        .reduce(0, (var total, var e) -> total + e));

    }
}