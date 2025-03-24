import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @BeforeAll
    static void setup() {
        System.err.println("@BeforeAll\n");
    }

    @BeforeEach
    void init() {
        System.err.println("@BeforeEach");
    }

    @Test
    void test() {
        System.err.println("@Test");
    }

    @Test
    void test2() {
        System.err.println("@Test2");
    }

    @Test
    void test3() {
        System.err.println("@Test3");
    }

    @Test
    void test4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        var result = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertTrue(result > 5, "Sum should be greater then 5");
    }

    @Test
    void test5() {
        int[] intArray = {1, 2, 3, 4, 5};
        assertAll("Numbers",
                () -> assertEquals(1, intArray[0]),
                () -> assertEquals(3, intArray[2]),
                () -> assertEquals(4, intArray[3]),
                () -> assertEquals(5, intArray[4])
        );
    }

    @AfterEach
    void cleanup() {
        System.err.println("@AfterEach\n");
    }

    @AfterAll
    static void tearDown() {
        System.err.println("\n@AfterAll");
    }
}
