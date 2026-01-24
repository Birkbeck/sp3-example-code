package isp;

interface Priceable {
    void calculatePrice();
}

interface Exportable {
    void generateCustomsForms();
}

class LocalDeliveryType implements Priceable {
    @Override
    public void calculatePrice() {}
}

class InternationalDeliveryType implements Priceable, Exportable {
    @Override
    public void generateCustomsForms() {

    }

    @Override
    public void calculatePrice() {

    }
}