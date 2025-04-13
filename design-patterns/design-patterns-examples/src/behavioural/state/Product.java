package behavioural.state;


public abstract class Product {

    private final float mPrice;

    public Product(float price) {
        mPrice = price;
    }

    public float getPrice() {
        return mPrice;
    }

}
