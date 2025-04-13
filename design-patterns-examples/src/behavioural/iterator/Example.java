package behavioural.iterator;

import java.util.Iterator;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        var ls = List.of("Mickey", "Simon", "Harold");

        System.out.println(ls.getClass());

        for (String s : ls) {
            System.out.print(s + " ");
        }
        System.out.println();

        Iterator it = ls.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for (var iter = ls.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        MyIterator myit = new MyIterator(ls.iterator());
        while (myit.hasNext()) {
            System.out.print(myit.next() + " ");
        }
        System.out.println();

    }
}

class MyIterator<T> implements Iterator<T> {
    private final Iterator<T> it;

    public MyIterator(Iterator<T> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public T next() {
        return it.next();
    }
}