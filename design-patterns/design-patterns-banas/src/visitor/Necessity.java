package visitor;

class Necessity implements Visitable {

    private final double price;

    Necessity(double item) {
        price = item;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

}