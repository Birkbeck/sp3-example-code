package behavioural.strategyalt;

import java.util.Comparator;

public class StringIntegerComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.parseInt((String) o1) -
            Integer.parseInt((String) o2);
    }
}
