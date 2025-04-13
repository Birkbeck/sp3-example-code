package structural.decorator.products;

public class DVD extends Product {
    private final String mtitle;

    public DVD(String title, float price) {
        super(price);
        mtitle = title;
    }
}
