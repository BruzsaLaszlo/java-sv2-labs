package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    Ship ship;

    @BeforeEach
    void setUp() {

        ship = new Ship("Evergreen", 2005, 374);

    }

    @Test
    void testName() {

        assertEquals("Evergreen", ship.getName());
        assertNotEquals("Evergiven", ship.getName());

    }

    @Test
    void testYearOfConstruction() {

        assertEquals(2005, ship.getYearOfConstruction());
        assertTrue(2005 == ship.getYearOfConstruction());
        assertFalse(2015 == ship.getYearOfConstruction());

    }

    @Test
    void testLength() {

        assertEquals(370, ship.getLength(), 10);

    }

    @Test
    void testNull() {

        Ship ship2 = null;
        assertNull(ship2);
        assertNotNull(ship);

    }

    @Test
    void testSameObject() {

        Ship ship2 = ship;
        assertSame(ship2, ship);

    }

    @Test
    void testNotSameObject() {

        Ship ship2 = new Ship("Evergreen", 2005, 374);
        assertNotSame(ship2, ship);

    }
}