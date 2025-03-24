package behavioural.strategyalt;

import java.util.Comparator;

public class ReverseComparator implements Comparator {
    private final Comparator c;

    public ReverseComparator(Comparator c) {
        this.c = c;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return c.compare(o2, o1);
    }
}