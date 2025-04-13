import java.util.*;

class Vehicle {
    void turn() {
        System.out.println("turning...");
    }
}

class Rocket extends Vehicle {
    void fly() {
        System.out.println("flying...");
    }
}

public class Sample {
    public static void main(String[] args) {
        Vehicle vehicle = new Rocket();

        vehicle.turn();

        vehicle.fly(); //ERROR, but if we change Vehicle vehicle to var vehicle, this code will compile
    }
}