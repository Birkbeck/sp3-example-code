package hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    public void testPutAndGet() {
        HashMap<String, Integer> map = new HashMap<>(10);
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
    }

    @Test
    public void testRemove() {
        HashMap<String, Integer> map = new HashMap<>(10);
        map.put("one", 1);
        map.remove("one");
        assertNull(map.get("one"));
    }

    // Add more tests for containsKey method
}