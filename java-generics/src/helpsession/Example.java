package helpsession;

import java.util.ArrayList;
import java.util.List;

interface Parent {
    Clazz meth(Clazz arg);
}

interface Child extends Parent {
    SubClazz meth(Clazz arg);
}

class Clazz {
    static Clazz acceptClazz(Clazz cls) {
        return cls;
    }

    Clazz makeClazz() {
        return new SubClazz();
    }
}

// Overloading or overriding
// Covariant return types

class SubClazz extends Clazz {
}

public class Example {
    public static void main(String[] args) {
        final int SIZE = 10;
        Clazz cl = new SubClazz();
        cl = new SubClazz();
        //SubClazz scl = (SubClazz) new Clazz(); // oops!!!

        Clazz.acceptClazz(new SubClazz());

        Clazz[] array = new Clazz[SIZE];
        array[0] = new SubClazz();
        array = new SubClazz[SIZE];
        //array[0] = new Clazz(); // compiles but runtime error

        //List<Clazz> lc = new ArrayList<SubClazz>(); //; won't work invariant

        List<?> lc = new ArrayList<Clazz>();
        //System.out.println(lc.getClass().getTypeName());
        List<? extends Clazz> lst = new ArrayList<SubClazz>();
        List<? super Clazz> lst2 = new ArrayList<Object>();

        List<? super Clazz> superClazz = null;
        List<? super SubClazz> superSubClazz = null;

        superSubClazz = superClazz;
        // superClazz = superSubClazz; = NO!


    }
}
