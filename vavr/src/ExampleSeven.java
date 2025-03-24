import static io.vavr.API.*;

public class ExampleSeven {
    public static void main(String[] args) {
        int x = 1;
        String output = switch (x) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "other";
        };

        output = Match(x).of(
            Case($(1), "one"),
            Case($(2), "two"),
            Case($(), "other"));
    }
}
