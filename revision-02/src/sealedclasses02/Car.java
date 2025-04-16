package sealedclasses02;

public non-sealed class Car extends Vehicle {
    private final int numOfSeats;

    Car(int numOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }
}
