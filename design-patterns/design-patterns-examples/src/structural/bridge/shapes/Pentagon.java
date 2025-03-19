package structural.bridge.shapes;

public class Pentagon extends Shape {

    public Pentagon(Colour c) {
        super(c);
    }

    @Override
    public void applyColour() {
        System.out.print("Pentagon filled with color ");
        colour.applyColour();
    }

}