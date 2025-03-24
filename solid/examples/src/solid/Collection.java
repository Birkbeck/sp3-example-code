package solid;

import java.util.Iterator;

public interface Collection<E> extends Iterable<E> {
    //-- Array operations
    Object[] toArray();

    <T> T[] toArray(T[] a);

    //-- Basic operations
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E o);                    // Optional

    boolean remove(Object o);            // Optional

    @Override
    Iterator<E> iterator();

    //-- Collection operations
    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c); // Optional

    boolean removeAll(Collection<?> c);  // Optional

    boolean retainAll(Collection<?> c);  // Optional

    void clear();                        // Optional
}