package creational.abstractfactory.cars;

public class Car {

    private final CarWindow mwindow;
    private final CarEngine mengine;

    public Car(CarFactoryInterface factory) {
        // Use the factory to fill in the parts
        mwindow = factory.getWindow();
        mengine = factory.getEngine();
    }

    @Override
    public String toString() {
        return mwindow.toString() + " " + mengine.toString();
    }
}
