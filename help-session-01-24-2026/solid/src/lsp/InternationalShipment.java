package lsp;

import srp.NewShipment;

public class InternationalShipment extends NewShipment {
    @Override
    public void setWeight(double weight) {
        if (weight > 1000) {
            throw new RuntimeException("Cannot use air cargo — too heavy!");
        }
        super.setWeight(weight);
    }
}
// if a method expects a NewShipment, it might crash if passed an InternalShipment
// make any constraints be part of the higher level design and not part of a subclass.
