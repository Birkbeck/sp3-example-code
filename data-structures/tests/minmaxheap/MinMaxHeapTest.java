package minmaxheap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxHeapTest {

    @Test
    public void givenUnOrderedArray_WhenCreateMinMaxHeap_ThenIsEqualWithMinMaxHeapOrdered() {
        List<Integer> list = Arrays.asList(34, 12, 28, 9, 30, 19, 1, 40);
        MinMaxHeap<Integer> minMaxHeap = new MinMaxHeap<>(list);
        minMaxHeap.create();
        assertEquals(Arrays.asList(1, 40, 34, 9, 30, 19, 28, 12), list);
    }

    @Test
    public void givenNewElement_WhenInserted_ThenIsEqualWithMinMaxHeapOrdered() {
        MinMaxHeap<Integer> minMaxHeap = new MinMaxHeap(8);
        minMaxHeap.insert(34);
        minMaxHeap.insert(12);
        minMaxHeap.insert(28);
        minMaxHeap.insert(9);
        minMaxHeap.insert(30);
        minMaxHeap.insert(19);
        minMaxHeap.insert(1);
        minMaxHeap.insert(40);
        assertEquals(Arrays.asList(1, 40, 28, 12, 30, 19, 9, 34), minMaxHeap.getMinMaxHeap());
    }
}