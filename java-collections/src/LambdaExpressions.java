package collections;

public class LambdaExpressions {


    static void doo(Foo f) {
        f.bar("baz");
    }

    public static void main(String[] args) {
        doo(System.out::println);
        doo(x -> System.out.println(x));
    }

    interface Foo {
        void bar(Object o);
    }
}
