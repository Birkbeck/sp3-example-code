package reflection.sub;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reflection.Base;

import static org.junit.jupiter.api.Assertions.*;

class CSubTest {
    Base base;

    @BeforeEach
    void setUp() {
        base = new CSub();
    }

    @AfterEach
    void tearDown() {
        base=null;
    }

    @Test
    void print() {
        assertEquals(">>> CSub", base.print());
    }
}