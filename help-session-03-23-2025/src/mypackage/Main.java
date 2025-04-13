package mypackage;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        newStyle();
    }

    static void newStyle() {
        var list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        // list.add(3);

        for (var s : list) {
            System.out.println(s);
        }
    }

    static void oldStyle() {
        var list = new ArrayList();
        list.add("A");
        list.add(3);
        list.add("B");
        list.add(1.2);

        list.stream().forEach(System.out::println);
        //list.stream().filter(x -> length(x) > 3)
    }
}
