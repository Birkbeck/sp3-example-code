import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numbers.forEach((final Integer e) -> System.out.println(e));

        numbers.forEach((final e) -> System.out.println(e)); //ERROR
        //To use the final annotation we have to use the type

        //Likewise, to use other user defined annotations, like @NotNUll, we need to use type
        //numbers.forEach((@NotNull Integer e) -> System.out.println(e));
    }
}