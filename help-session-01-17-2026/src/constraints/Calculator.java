package constraints;

public class Calculator<T extends Number> {
    private T value;

    public double square(){
        return value.doubleValue() * value.doubleValue();
    }
}
