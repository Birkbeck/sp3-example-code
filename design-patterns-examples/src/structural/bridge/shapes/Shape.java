package structural.bridge.shapes;

public abstract class Shape {
    //Composition - implementor
    protected Colour colour;

    //constructor with implementor as input argument
    public Shape(Colour c) {
        colour = c;
    }

    public Shape() {
        colour = new GreenColour();
    }

    abstract public void applyColour();
}