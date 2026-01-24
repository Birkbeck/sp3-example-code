package isp;

public interface LogisticsOperations {
    void calculatePrice();
    void generateCustomsForms(); // Local shipments do not need this.
}
