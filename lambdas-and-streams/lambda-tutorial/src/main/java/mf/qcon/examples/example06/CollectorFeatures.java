package mf.qcon.examples.example06;

import java.util.*;
import java.util.function.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static mf.qcon.examples.example06.Dish.menu;

public class CollectorFeatures {

    public static void main(String... args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Most caloric Dish by type: " + mostCaloricDishByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    private static Map<Dish.Type, Dish> mostCaloricDishByType() {
        BinaryOperator<Dish> binOp = BinaryOperator.maxBy(comparingInt(Dish::getCalories));
        return menu.stream().collect(groupingBy(Dish::getType,
            collectingAndThen(
                reducing(BinaryOperator.maxBy(comparingInt(Dish::getCalories))), Optional::get)));
    }
}
