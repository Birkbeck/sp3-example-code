package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyOtherClassTest {
    private final MyOtherClass moc = new MyOtherClass();

    @Test
    void addZero() {
        assertEquals(10, moc.add(0, 10));
    }

    @Test
    void addSameNumber() {
        assertEquals(20, moc.add(10, 10), "Should be the arg doubled");
    }

    @Test
    void addNegativeAndPositive() {
        assertEquals(0, moc.add(10, -10));
    }
}