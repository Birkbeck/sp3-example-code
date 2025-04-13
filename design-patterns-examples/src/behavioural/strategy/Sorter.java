package behavioural.strategy;

/**
 * An interface used via the Strategy pattern to allow
 * demonstration of different sorting algorithms
 */
public interface Sorter {

    /**
     * precondition: array is an array of integers in no specific order
     * postcondition: array will be the same integers, but sorted by value from lowest to highest
     *
     * @param array Input array
     */
    void sort(int[] array);


}
