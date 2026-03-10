package defmethod;

@FunctionalInterface
public interface Dummy {
    void myMethod(); // only one single abstract method in a FunctionalInterface
    default void myDefMethod(String s) {
        System.out.println(s);
    }
    default void anotherDefMethod(int i){
        // ...
    }
    //void myAlternativeMethod();
}
