package sealedclasses02;

public final class Truck extends Vehicle {
    private final int capacity;


    Truck(int capacity, String registrationNumber) {
        super(registrationNumber);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
