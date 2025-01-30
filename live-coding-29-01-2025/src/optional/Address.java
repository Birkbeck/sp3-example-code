package optional;

import lombok.Data;

import java.util.Optional;
@Data
public class Address {
    private String addressLine;
    private String city;
    private Country country;

    public Address(String addressLine, String city) {
        this.addressLine = addressLine;
        this.city = city;
    }
}