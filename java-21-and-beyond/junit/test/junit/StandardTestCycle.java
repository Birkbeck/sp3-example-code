package junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StandardTestCycle {
    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.\n");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        System.out.println("Success");
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
        System.out.println("testShowSomething");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.\n");
    }

    @Test
    void shouldThrowException() {
        System.out.println("shouldThrowException");
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        assertEquals(exception.getMessage(), "Not supported");
    }

    @Test
    void assertThrowsException() {
        System.out.println("assertThrowsException");
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }
}
