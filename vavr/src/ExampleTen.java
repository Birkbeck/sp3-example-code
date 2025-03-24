import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExampleTen {
    public static void main(String[] args) {
        original();
        vavr();
    }

    private static void original(){
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println(intList);
        Stream<Integer> intStream = intList.stream();
        intList.add(10);
        intList.forEach(System.out::println);
    }

    private static void vavr(){
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        io.vavr.collection.Stream<Integer> vavrStream = io.vavr.collection.Stream.ofAll(intList);
        intList.add(10);
        vavrStream.forEach(System.out::println); // blows up as changes to the underlying list are not processed
    }
}
