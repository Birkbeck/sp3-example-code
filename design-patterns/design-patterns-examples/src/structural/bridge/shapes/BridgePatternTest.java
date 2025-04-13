package structural.bridge.shapes;

public class BridgePatternTest {
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColour());
        tri.applyColour();

        Shape pent = new Pentagon(new GreenColour());
        pent.applyColour();
    }
}
