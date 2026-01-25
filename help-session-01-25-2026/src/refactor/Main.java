package refactor;

import interfaces.Shipment;
import model.ShipmentImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
// import java.util.function.Predicate;

public class Main {
    static void main() {
        List<Shipment> shipments = new ArrayList<>();
        shipments.add(new ShipmentImpl(250, "Standard", "package-3"));
        shipments.add(new ShipmentImpl(250, "Express", "package-4"));
        shipments.add(new ShipmentImpl(150, "Fragile", "package-5"));
        shipments.add(new ShipmentImpl(150, "Express", "package-6"));
        shipments.add(new ShipmentImpl(5, "Fragile", "package-7"));
        shipments.forEach(System.out::println);
        System.out.println();

        //var results = getFragileShipments(shipments);
        //var results = getFragileShipmentsLambda(shipments);
        shipments.stream()
                .filter(s -> s.getType().equalsIgnoreCase("Fragile"))
                .filter(s -> s.getWeight() < 10.0)
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .forEach(System.out::println);
        //.toList();
        //results.forEach(System.out::println);

//        double totalWeight = shipments.stream()
//                .mapToDouble(Shipment::getWeight)
//                .sum();
//        System.out.printf("Total weight of shipments is %.2f", totalWeight);

        DoubleSummaryStatistics stats = shipments.stream()
                .mapToDouble(Shipment::getWeight)
                .summaryStatistics();
        System.out.printf("Max: %.2f ", stats.getMax());
        System.out.printf("Min: %.2f ", stats.getMin());
        System.out.printf("Average: %.2f ", stats.getAverage());
        System.out.printf("Sum: %.2f ", stats.getSum());
        System.out.printf("Count: %d ", stats.getCount());
        System.out.println();
    }

    static List<String> getFragileShipments(List<Shipment> shipment) {
        List<String> result = new ArrayList<>();

        for (Shipment s : shipment) {
            if (s.getType().equalsIgnoreCase("Fragile")) {
                if (s.getWeight() < 10.0) {
                    result.add(s.getName().toUpperCase());
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    static List<String> getFragileShipmentsLambda(List<Shipment> shipment) {
        return shipment.stream()
                .filter(s -> s.getType().equalsIgnoreCase("Fragile"))
                .filter(s -> s.getWeight() < 10.0)
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .toList();
    }

}
