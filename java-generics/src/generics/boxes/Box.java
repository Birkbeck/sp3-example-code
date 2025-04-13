package generics.boxes;

public class Box<T> {
    private final T data;

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
