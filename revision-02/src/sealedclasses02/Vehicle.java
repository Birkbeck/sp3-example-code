package sealedclasses02;

public abstract sealed class Vehicle permits Car, Truck {
    private final String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }


}
