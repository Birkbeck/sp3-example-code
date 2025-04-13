package covariant;

import java.util.ArrayList;
import java.util.List;

public final class ContravariantGenericsExample {

    private ContravariantGenericsExample() {
    }

    public static void main(String[] args) {
        List<A> aList = new ArrayList<>();
        aList.add(new A());

        List<? super B> bList = aList;
        bList.add(new B());

        System.out.println(bList);
    }

    private static class A {
    }

    private static class B extends A {
    }
}
