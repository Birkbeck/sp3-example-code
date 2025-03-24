import javax.naming.OperationNotSupportedException;

public interface StorageDepot<T> {

    void add(T t);

    // Re-use of other methods:
    default void addAll(Iterable<T> iter) {
        for (T t : iter) {
            add(t);
        }
    }

    // Default implementation of optional methods:
    default void remove(T t) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
