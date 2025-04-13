package visitor;

class Liquor implements Visitable {

    private final double price;

    Liquor(double item) {
        price = item;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

}