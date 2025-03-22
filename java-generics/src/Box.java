public class Box<T> {
    T data;

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
