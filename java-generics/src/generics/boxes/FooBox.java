package generics.boxes;

import generics.Foo;

public class FooBox {
    private final Foo data;

    public FooBox(Foo data) {
        this.data = data;
    }

    public Foo getData() {
        return data;
    }
}
