package helpsession;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        System.out.println(integerList);
        List<Number> otherList = new ArrayList<>();
        Collections.copy(integerList, otherList);
        System.out.println(otherList);
    }
}

class Collections {
    static <E> void copy(List<? extends E> src, List<? super E> dst) {
        for (E elem : src) {
            dst.add(elem);
        }
    }
}