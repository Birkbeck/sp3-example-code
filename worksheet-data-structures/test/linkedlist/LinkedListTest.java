package linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
    }

    @Test
    public void testRemove() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.remove(1);
        assertEquals(1, list.size());
        assertFalse(list.contains(1));
    }

    // Add more tests for contains and size methods
}