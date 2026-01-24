package ocp;

import srp.NewShipment;

public class NewLogisticsManager {
    public double calculate(NewShipment newShipment, ShippingStrategy shippingStrategy) {
        return shippingStrategy.calculate(newShipment);
    }
}
