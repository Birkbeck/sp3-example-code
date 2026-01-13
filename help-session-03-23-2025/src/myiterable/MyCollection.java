package myiterable;

import java.util.Iterator;

public class MyCollection<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                // ...
                return false;
            }

            @Override
            public E next() {
                // ...
                return null;
            }
        };
    }
}
