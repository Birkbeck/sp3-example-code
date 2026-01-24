package srp;

public class Shipment {
    private final static double RATE = 0.20;
    private double weight;

    // Resp #1
    public double getWeight() {
        return weight;
    }

    // Resp #2
    public double calculateTax() {
        return getWeight() * RATE;
    }

    // Resp #3
    public void saveToFile(){
        // code to save the object to a database or file
    }
}
