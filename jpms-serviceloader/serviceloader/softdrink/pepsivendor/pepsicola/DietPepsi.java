package pepsicola;

import products.Drink;
import health.LowCalorie;

@LowCalorie
public class DietPepsi implements Drink {
    private final int size;

    public DietPepsi(int size) { this.size = size; }
    public static DietPepsi provider() { return new DietPepsi(300); }
    public String getName() { return "Diet Pepsi";}
    public int getSize() { return size;}
}
