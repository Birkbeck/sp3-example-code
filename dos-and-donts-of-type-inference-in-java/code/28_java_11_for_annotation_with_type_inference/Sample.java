import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numbers.forEach((final Integer e) -> System.out.println(e));

        //numbers.forEach((@NotNull Integer e) -> System.out.println(e));

        //numbers.forEach((final e) -> System.out.println(e)); //ERROR
        //Likewise can't use @NotNull above where final is used

        numbers.forEach((final var e) -> System.out.println(e));
        //Likewise can use @NotNull above where final is used
    }
}