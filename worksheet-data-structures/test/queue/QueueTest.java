package queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue(1);
        assertEquals(1, queue.peek());
    }

    // Add more tests for isEmpty method
}