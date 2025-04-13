package generics;

class Storage<T extends Object> {
    private T x;

    public T getValue() {
        return x;
    }

    public void setValue(T value) {
        x = value;
    }
}
