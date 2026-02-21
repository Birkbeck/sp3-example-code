package demotwo;

// Decoupling
// Flexibility
// Testing - mock object

public class Main {
    static void main() {
        Engine engine = new EngineImplTwo();
        Car car = new CarImpl(engine);
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

class EngineImplTwo implements Engine {
    public void start() {
        System.out.println("Vroom!!!");
    }
}

interface Car {
    void start();
}

class CarImpl implements Car {
    Engine engine;

    public CarImpl(Engine engine) {
        this.engine = engine;
    }
    public void start() {
        engine.start();
        System.out.println("Car started");
    }
}


