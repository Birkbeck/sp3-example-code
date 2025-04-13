package creational.abstractfactory.cars;

public class Main {

    public static void main(String[] args) {
        final Car fordcar = new Car(new FordFactory());
        System.out.println(fordcar);

        final Car bmwcar = new Car(new BMWFactory());
        System.out.println(bmwcar);
    }
}
