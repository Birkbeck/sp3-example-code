package aic;

import interfaces.Shipment;
import model.ShipmentImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static void main() {
        List<Shipment> shipments = new ArrayList<>();

        shipments.add(new ShipmentImpl());
        shipments.add(new ShipmentImpl());

        // Pre Java 2 version
        Collections.sort(shipments, new MyComparator());

        // Anonymous Inner Class version
        Collections.sort(shipments, new Comparator<Shipment>() {
            @Override
            public int compare(Shipment o1, Shipment o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        // lambda expression version
        shipments.sort((s1,s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
    }
}

class MyComparator implements Comparator<Shipment> {
    @Override
    public int compare(Shipment o1, Shipment o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}