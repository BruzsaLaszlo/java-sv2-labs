package junit5assert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    @Test
    void testNull() {

        Dragon dragon = new Dragon("Dragho", 12, 10.12345);
        Dragon dragon2 = null;
        assertNull(dragon2);
        assertNotNull(dragon);

    }

    @Test
    void testSameObjects() {

        Dragon dragon = new Dragon("Dragho", 12, 10.12345);
        Dragon dragon3 = dragon;
        assertSame(dragon3, dragon);

    }

    @Test
    void testNotSameObjects() {

        Dragon dragon = new Dragon("Dragho", 12, 10.12345);
        Dragon dragon4 = new Dragon("Dragho", 12, 10.12345);
        assertNotSame(dragon4 , dragon);

    }

    @Test
    void testName() {

        Dragon dragon = new Dragon("Dragho", 12, 10.12345);
        assertEquals("Dragho", dragon.getName());
        assertNotEquals("Sárkányka", dragon.getName());

    }

    @Test
    void testNumberOfHeads() {

        Dragon dragon = new Dragon("Dragho", 12, 10.12345);
        assertEquals(12, dragon.getNumberOfHeads());
        assertTrue(12 == dragon.getNumberOfHeads());
        assertFalse(13 == dragon.getNumberOfHeads());

    }

    @Test
    void testHeight() {

        Dragon dragon = new Dragon("Dragho", 12, 10.12345);
        assertEquals(10, dragon.getHeight(), 0.123456);

    }
}