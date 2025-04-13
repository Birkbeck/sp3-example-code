package behavioural.state;

// Abstract so we have to make something of a particular type
public abstract class GiftType {

    protected float mWrapPrice;

    // Method to wrap (abstract)
    public abstract void wrap();

    // Get the cost of this type of wrap
    public float getWrapPrice() {
        return mWrapPrice;
    }

}
