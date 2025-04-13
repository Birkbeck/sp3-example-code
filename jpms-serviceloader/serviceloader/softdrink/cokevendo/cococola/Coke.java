package cokevendo.cococola;

import products.Drink;

public class Coke implements Drink {
    public Coke() {
        System.out.println("creating " + this);
    }

    public String getName() { return "Coke";}

    public int getSize() { return 355; }
}
