package streamfromlists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    // Create a map from two different lists
    static void main() {
        List<String> keys = List.of("ID", "Name", "Role");
        List<String> values = List.of("101", "Jane", "Developer");

        Map<String, String> map = IntStream.range(0, keys.size())
                .boxed()
                .collect(Collectors.toMap(keys::get, values::get));

        System.out.println("Map: " + map);
    }
}
