package demo;

public class Main {
    static void main() {
        Car car = new CarImpl();
        car.start();
    }
}

interface Engine {
    void start();
}

class EngineImpl implements Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

interface Car {
    void start();
}

class CarImpl implements Car {
    Engine engine = new EngineImpl(); // hard-coded dependency

    public void start() {
        engine.start();
        System.out.println("Car started");
    }
}


