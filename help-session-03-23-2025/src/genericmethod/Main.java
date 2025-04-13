package genericmethod;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = List.of("a", "b", "c");
        addItemAndGet("z", collection);
    }

    static <T> T addItemAndGet(T element, Collection<T> collection) {
        collection.add(element);
        return element;
    }

    static <T> T getInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
