package process;

import java.util.ServiceLoader;
import products.Drink;

public class TakeOrder {
    public static void main(String[] args) {
        System.out.println("We're ready to take your order");
        System.out.println("What would you like?");

        ServiceLoader.load(Drink.class).stream()
            .map(ServiceLoader.Provider::get)
            .map(Drink::getInfo)
            .forEach(System.out::println);

        System.out.println("Please choose from the above.");
        System.out.println("");

    /*
        System.out.println("Let's reiterate...");
        System.out.println("");

        for(var drink: drinks) {
            System.out.println(drink.getInfo());
        }

        System.out.println("Let's reload and then reiterate...");
        System.out.println("");

        drinks.reload();
        for(var drink: drinks) {
            System.out.println(drink.getInfo());
        }
    */
    }
}
