package mf.qcon.talk.example08;

import mf.qcon.talk.example06.*;

import static mf.qcon.talk.example06.Dish.*;

public class Modularity {

    public static void main(String[] args) {
        Dish d1 = new Dish("chicken", false, 400, Dish.Type.MEAT);
        Dish d2 = new Dish("beef", false, 700, Dish.Type.MEAT);
        lightest(d1, d2);

    }

    public static Dish declareLightest(Dish d) {
        System.out.println(d + " is the lightest dish");
        return d;
    }

    public static Dish lightest(Dish d1, Dish d2) {
        if (d1.getCalories() < d2.getCalories()) return declareLightest(d1);
        else return declareLightest(d2);
    }
}
