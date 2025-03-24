package top;

import java.util.ArrayList;
import java.util.List;


final class Thing {
    private final List<String> strings;

    {
        strings = new ArrayList<>();
    }

    public static Thing of() {
        return new Thing();
    }

    public int addItem(String s) {
        strings.add(s);
        return strings.size() - 1;
    }

    public int indexOf(String s) {
        for (var i = 0; i != strings.size(); i++) {
            if (s.equals(strings.get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("(");

        boolean first = true;
        for (var s : strings) {
            if (first) {
                r.append(s);
                first = !first;
            }
            r.append(", ").append(s);
        }
        r.append(")");
        return r.toString();
    }

    public void reset() {
        strings.clear();
    }
}
