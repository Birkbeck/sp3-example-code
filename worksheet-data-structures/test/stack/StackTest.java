package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack(5);
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    // Add more tests for isEmpty method
}