package ocp;

import srp.NewShipment;

public class LogisticsManager {
    public double calculate(NewShipment s) {
        if (s.getType().equals("Standard")) {
            return s.getWeight() * 0.5;
        } else if (s.getType().equals("Express")) {
            return s.getWeight() * 1.5;
        }
        // How do we add "Drone" delivery?
        // This means modifiying this code.
        return 0;
    }
}
