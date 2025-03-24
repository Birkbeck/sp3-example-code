public class Foo {
    //Foo is not parameterised

    public static void main(String[] args) {
        Foo foo = new Foo();
        int k = foo.aMethod(5);
        String s = foo.aMethod("abc");
    }

    public <T> T aMethod(T x) {
        // will not compile without <T>
        // to indicate that this is a
        // parameterised method.
        return x;
    }
}
