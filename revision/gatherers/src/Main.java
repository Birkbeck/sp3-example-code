import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Example: Custom gatherer for grouping elements into fixed-size windows
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");
        var result = stream.gather(Gatherers.windowSliding(3)).toList();

        System.out.format("Result = %s\n",result);
    }
}