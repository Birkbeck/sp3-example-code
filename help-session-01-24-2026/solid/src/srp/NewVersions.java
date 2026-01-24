package srp;

class TaxCalculator {
    private final static double RATE = 0.20;

    // Resp #2
    public double calculateTax(NewShipment newShipment) {
        return newShipment.getWeight() * RATE;
    }
}

class ShipmentRepository {
    // Resp #3
    public void saveToFile(NewShipment newShipment) {
        // code to save the object to a database or file
    }
}
