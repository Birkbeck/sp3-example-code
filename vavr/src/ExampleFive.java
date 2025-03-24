import io.vavr.collection.List;

public class ExampleFive {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        System.out.println(intList);
        int sum = intList.sum().intValue();
        System.out.println(sum);
    }
}
