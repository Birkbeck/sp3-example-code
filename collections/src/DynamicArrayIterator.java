package collections;

import java.util.Iterator;

public class DynamicArrayIterator<E> implements Iterator<E> {

    private final DynamicArray<E> da;
    private int cursor = 0;

    public DynamicArrayIterator(DynamicArray<E> da) {
        this.da = da;
    }

    public boolean hasNext() {
        return cursor < da.size() - 1;
    }

    public E next() {
        cursor++;
        return da.get(cursor - 1);
    }

    public void remove() {
        da.remove(cursor - 1);
    }
}
