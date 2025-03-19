package creational.abstractfactory.cars;

public class BMWFactory implements CarFactoryInterface {

    @Override
    public CarEngine getEngine() {
        return new BMWEngine();
    }

    @Override
    public CarWindow getWindow() {
        return new BMWWindow();
    }

}
