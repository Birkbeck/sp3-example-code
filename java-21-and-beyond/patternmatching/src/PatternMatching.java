import java.util.function.Function;

interface Shape {
}

record Rectangle(double length, double width) implements Shape {
}

record Circle(double radius) implements Shape {
}

public class PatternMatching {
    public static void main(String[] args) {
        System.out.println(getPerimeter(new Circle(3.5)));
        //test("A String");
    }

    // switch Expressions

    public static double getPerimeter(Shape shape) throws
        IllegalArgumentException {
        if (shape instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

//    public static double getPerimeter(Shape shape) throws IllegalArgumentException {
//        return switch (shape) { // preview feature
//            case Rectangle r -> 2 * r.length() + 2 * r.width();
//            case Circle c -> 2 * c.radius() * Math.PI;
//            default -> throw new IllegalArgumentException("Unrecognized shape");
//        };
//    }

    // Guarded Patterns

    static void test(Object obj) {
        if (obj instanceof String s) {
            if (s.length() == 1) {
                System.out.println("Short: " + s);
            } else {
                System.out.println(s);
            }
        } else {
            System.out.println("Not a string");
        }
    }

//    static void test(Object obj) {
//        switch (obj) {
//            case String s && (s.length() == 1) -> System.out.println("Short: " + s);
//            case String s -> System.out.println(s);
//            default -> System.out.println("Not a string");
//        }
//    }

    // Parenthesized Patterns

//    static Function<Integer, String> testParen(Object obj) {
//        boolean b = true;
//        return switch (obj) {
//            case String s && b -> t -> s;
//            default -> t -> "Default string";
//        };
//    }

    static Function<Integer, String> testParen(Object obj) {
        boolean b = true;
        return switch (obj) {
            case (String s && b) -> {
                yield t -> s;
            }
            default -> t -> "Default string";
        };
    }
}

