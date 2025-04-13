package cokevendo.cococola;
import products.Drink;
import health.LowCalorie;

@LowCalorie
public class DietCoke implements Drink {
    public DietCoke() { System.out.println("creating " + this);}
    public String getName() { return "Diet Coke";}
    public int getSize() { return 355;}
}
