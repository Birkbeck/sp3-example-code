package priorityqueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

    @Test
    public void testInsertAndExtractMin() {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(3);
        pq.insert(1);
        pq.insert(2);
        assertEquals(1, pq.extractMin());
        assertEquals(2, pq.extractMin());
    }

    @Test
    public void testPeekMin() {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(3);
        pq.insert(1);
        assertEquals(1, pq.peekMin());
    }

    // Add more tests for heapify methods
}