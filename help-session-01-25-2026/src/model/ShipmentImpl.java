package model;

import interfaces.Shipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentImpl implements Shipment {
    private double weight;
    private String type;
    private String name;
}