public class Example<T> {
    void method(Object item) {
        if (item instanceof T) {...} // Compiler error!
        T anotherItem = new T(); // Compiler error!
        T[] itemArray = new T[10]; // Compiler error!
    }
}
