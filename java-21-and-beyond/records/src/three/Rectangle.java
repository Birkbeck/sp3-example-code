package three;

public record Rectangle(double length, double width) {
//    public Rectangle(double length, double width) {
//        if (length <= 0 || width <= 0) {
//            throw new java.lang.IllegalArgumentException(
//                String.format("Invalid dimensions: %f, %f", length, width));
//        }
//        this.length = length;
//        this.width = width;
//    }

    public Rectangle {
        if (length <= 0 || width <= 0) {
            throw new java.lang.IllegalArgumentException(
                String.format("Invalid dimensions: %f, %f", length, width));
        }
    }

    // Public accessor method
    public double length() {
        System.out.println("Length is " + length);
        return length;
    }
}
