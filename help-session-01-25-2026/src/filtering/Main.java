package filtering;

import interfaces.Shipment;
import model.ShipmentImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    static void main() {
        List<Shipment> shipments = new ArrayList<>();
        shipments.add(new ShipmentImpl(50,"Express","package-1"));
        shipments.add(new ShipmentImpl(50,"Standard", "package-2"));
        shipments.add(new ShipmentImpl(250,"Express","package-3"));
        shipments.add(new ShipmentImpl(150,"Standard", "package-4"));

        // define whether a shipment is heavy
        Predicate<Shipment> isHeavyExpressItem = s ->
                s.getType().equals("Express") && s.getWeight() > 100;

        List<Shipment> result = shipments.stream()
                .filter(isHeavyExpressItem)
                .toList();
        result.forEach(System.out::println);
    }
}
