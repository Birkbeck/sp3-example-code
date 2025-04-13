package covariant;


// The following assignment is dangerous because it may end up in ArrayStoreException

public class CovariantArraysExample {
    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        Number[] numbers = integers;
        numbers[0] = 25;
    }
}
