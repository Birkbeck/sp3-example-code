package creational.prototype.client;

//Prototype

public abstract class Item {
    private String title;
    private double price;

    @Override
    public Item clone() {
        Item clonedItem = null;
        try {
            //use default object clone.
            clonedItem = (Item) super.clone();
            //specialised clone
            clonedItem.setPrice(price);
            clonedItem.setTitle(title);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedItem;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

//Concrete Prototypes

class Book extends Item {
    //extra book stuff
}

class CD extends Item {
    //extra cd stuff
}
