package structural.decorator.cars;

public class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car c) {
        car = c;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}