package structural.adapter.enumerator;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Adapts Enumeration interface to Iterator interface.
 * Does not support remove() operation.
 */
public record EnumerationAsIterator(Enumeration enumeration) implements Iterator {

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    /**
     * Not supported.
     *
     * @throws UnsupportedOperationException if invoked
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove");
    }
}