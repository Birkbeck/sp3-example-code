package mf.qcon.examples.example10;

import org.junit.*;

import java.util.*;

import static java.util.Optional.*;
import static org.junit.Assert.*;

public class OptionalTest {

    public static Optional<Integer> s2i(String s) {
        try {
            return of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return empty();
        }
    }

    @Test
    public void testMap() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("a", "5");
        param.put("b", "true");
        param.put("c", "-3");

        assertEquals(5, readDuration(param, "a"));
        assertEquals(0, readDuration(param, "b"));
        assertEquals(0, readDuration(param, "c"));
        assertEquals(0, readDuration(param, "d"));
    }

    public int readDuration(Map<String, String> params, String name) {
        return ofNullable(params.get(name))
            .flatMap(OptionalTest::s2i)
            .filter(i -> i > 0).orElse(0);
    }
}
