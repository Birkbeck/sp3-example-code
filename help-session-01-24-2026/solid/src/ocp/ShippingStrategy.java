package ocp;

import srp.NewShipment;

public interface ShippingStrategy {
    double calculate(NewShipment newShipment);
}
