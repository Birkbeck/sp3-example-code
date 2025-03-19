package generics.dogs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ObjectPrinter<T> {
    private final List<T> items;

    public ObjectPrinter(List<T> items) {
        this.items = new LinkedList<>(items);  // Defensive copy
    }

    public static void main(String[] args) {
        String[] strings = {"To", "be", "or", "not", "to", "be"};

        List<String> stringList = new LinkedList<>();
        Collections.addAll(stringList, strings);

        ObjectPrinter<String> op = new ObjectPrinter<>(stringList);
        op.printAll();
    }

    public void printAll() {
        for (T t : items) {
            System.out.println(t.toString());
        }
    }
}
