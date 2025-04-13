package creational.abstractfactory.cars;

// An interface is a good choice for an abstract factory

public interface CarFactoryInterface {

    CarWindow getWindow();

    CarEngine getEngine();
}
