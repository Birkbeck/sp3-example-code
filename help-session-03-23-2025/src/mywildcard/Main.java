package mywildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var listA = new ArrayList<A>();
        var listB = new ArrayList<B>();
        var listC = new ArrayList<C>();
        var listD = new ArrayList<C>();

        listD = listC;
        //listA = listB;
        //listB = listA;

        var a = new A();
        var b = new B();

        System.out.println(a instanceof A);
        System.out.println(a.getClass());

        a = b;
        // b = a; NO

        //processElementsA(listA);
        // processElementsA(listB); NO

        processElements(listA);
        processElements(listB);
        processElements(listC);
        processElements(listD);

        var anotherList = new ArrayList<Integer>();

        // processElements(anotherList); NO

        insertElements(listA);
        var yetAnotherList = new ArrayList<Object>();
        insertElements(yetAnotherList);
    }

    static void processElements(List<? extends A> elements) {
        for (var e : elements) {
            System.out.println(e);
        }
    }

    static void insertElements(List<? super A> elements) {
        elements.add(new A());
        elements.add(new B());
        elements.add(new C());
    }

//    static void processElementsA(List<A> elements) {
//        for (A e : elements) {
//            System.out.println(e);
//        }
//    }

    static void processElementsA(List<?> elements) {
        for (var e : elements) {
            System.out.println(e);
        }
    }
}
