package one;

public final class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double length() {
        return this.length;
    }

    public double width() {
        return this.width;
    }

    // Implementation of equals () and hashCode (), which specify
    // that two record objects are equal if they
    // are of the same type and contain equal field values.

    // An implementation of toString () that returns a string
    // representation of all the record class's fields,
    // including their names.
}