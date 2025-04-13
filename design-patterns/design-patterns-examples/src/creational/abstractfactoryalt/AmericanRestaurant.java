package creational.abstractfactoryalt;

public class AmericanRestaurant implements Restaurant {
    public Appetizer getAppetizer() {
        return new Oysters();
    }

    public Entree getEntree() {
        return new Steak();
    }

    public Dessert getDessert() {
        return new CheeseCake();
    }
}