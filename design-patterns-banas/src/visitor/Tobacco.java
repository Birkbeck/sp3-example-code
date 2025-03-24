package visitor;

class Tobacco implements Visitable {

    private final double price;

    Tobacco(double item) {
        price = item;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

}