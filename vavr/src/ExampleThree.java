import io.vavr.control.Try;

public class ExampleThree {
    public static void main(String[] args) {
        Try<Integer> success = Try.of(() -> 1 / 0);
        int failure = success.getOrElse(0);
        System.out.println(failure);
    }
}
