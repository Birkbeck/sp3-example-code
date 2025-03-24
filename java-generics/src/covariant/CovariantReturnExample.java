package covariant;

public class CovariantReturnExample {

    interface SuperType {
    }

    interface SubType extends SuperType {
    }

    interface A {
        SuperType getType();
    }

    interface B extends A {
        SubType getType();
    }
}