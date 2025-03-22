public class Bar<T> {
    //Bar is parameterised

    public static void main(String[] args) {
        Bar<Integer> bar = new Bar<>();
        int k = bar.aMethod(5);
        //String s = bar.aMethod("abc");
        //Compilation error in the above line
    }

    public T aMethod(T x) {
        return x;
    }
}
