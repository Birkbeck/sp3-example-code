package sealedclasses03;

public sealed interface Vehicle permits Car, Truck {
    String registrationNumber();
}

record Car(int numberOfSeats, String registrationNumber) implements Vehicle {
    @Override
    public String registrationNumber() {
        return registrationNumber;
    }
}

record Truck(int capacity, String registrationNumber) implements Vehicle {
    @Override
    public String registrationNumber() {
        return registrationNumber;
    }
}