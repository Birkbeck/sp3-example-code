package structural.composite.product;

import java.util.List;

public class ProductGroup extends Product {

    private final List<Product> mGroupContents;
    private float mDiscount;

    public ProductGroup(List<Product> products, float discount) {
        super(0.0f); // Have to set something, but we don't use mPrice so the value is irrelevant
        mGroupContents = products;
    }

    // Override this so it computes the discounted price
    @Override
    public float getPrice() {
        float price = 0.0f;
        for (Product p : mGroupContents) price += p.getPrice();
        return price * mDiscount;
    }

}
