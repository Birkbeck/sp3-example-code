package example;

final class Square extends Shape {
    private final double length;

    public Square(double length) {
        this.length = length;
    }

    public double area() {
        return length * length;
    }
}
