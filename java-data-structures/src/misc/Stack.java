package datastructure;

public interface Stack<E> {

    void push(E item);

    E pop() throws java.util.EmptyStackException;

    boolean isEmpty();
}
