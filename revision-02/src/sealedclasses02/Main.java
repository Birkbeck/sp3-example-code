package sealedclasses02;

public class Main {
    public static void main(String[] args) {
        var vehicle = new Car(4, "007");

        //...

        if (vehicle instanceof Car car) {
            System.out.println(car.getNumOfSeats());
        } else if (vehicle instanceof Truck truck) {
            System.out.println(truck.getCapacity());
        } else {
            throw new RuntimeException("Unknown instance of vehicle");
        }
    }
}
