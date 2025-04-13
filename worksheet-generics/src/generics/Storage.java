package generics;

class Storage<T> {
  private T x;

  public void setValue(T value) {
    x = value;
  }

  public T getValue() {
    return x;
  }
}