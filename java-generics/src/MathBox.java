public class MathBox<E extends Number> extends Box<Number> {

    public MathBox(E data) {
        super(data);
    }

    public double sqrt() {
        return Math.sqrt(getData().doubleValue());
    }
}
