package collections;

import java.util.Arrays;
import java.util.List;

public class CollectionToArrayExample {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "orange");
        //old methods
        String[] array = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array));
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        //new method
        String[] array2 = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array2));
    }
}
