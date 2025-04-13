import io.vavr.control.Option;

public class ExampleOne {
    public static void main(String[] args) {
        Option<Object> noneOption = Option.of(null);
        Option<Object> someOption = Option.of("Hello, World!");
        System.out.println(noneOption);
        System.out.println(someOption);
    }
}