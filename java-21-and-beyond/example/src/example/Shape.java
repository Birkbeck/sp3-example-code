package example;

public abstract sealed class Shape permits Circle, Rectangle {
    public abstract double area();

    @Override
    public String toString() {
        return "Shape{}";
    }
}
