package mf.qcon.examples.example08;

import mf.qcon.examples.example06.*;

import static mf.qcon.examples.example06.Dish.menu;

public class Modularity {

    public static void main(java.lang.String[] args) {
        Dish d1 = new Dish("chicken", false, 400, Dish.Type.MEAT);
        Dish d2 = new Dish("beef", false, 700, Dish.Type.MEAT);
        lightest(d1, d2);

        System.out.println("Lighetst dish in menu is: " +
            menu.stream().reduce(Modularity::lightest).get()
        );

        declareLightest(minCalories(d1, d2));
        System.out.println("Lighetst dish in menu is: " +
            menu.stream().reduce(Modularity::minCalories).get()
        );
    }

    public static Dish declareLightest(Dish d) {
        System.out.println(d + " is the lightest dish");
        return d;
    }

    public static Dish lightest(Dish d1, Dish d2) {
        if (d1.getCalories() < d2.getCalories()) return declareLightest(d1);
        else return declareLightest(d2);
    }

    public static Dish minCalories(Dish d1, Dish d2) {
        if (d1.getCalories() < d2.getCalories()) return d1;
        else return d2;
    }
}
