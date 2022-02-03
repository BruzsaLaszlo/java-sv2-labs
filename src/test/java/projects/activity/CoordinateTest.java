package projects.activity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CoordinateTest {


    @Test
    void testInvalidLatitude() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(190.5, -34.789);
        });
    }

    @Test
    void testInvalidLongitude() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(30.5, -200);
        });
    }

    @Test
    void testInvalidCoordinate() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-91.0, 180.1);
        });
    }

    @Test
    void testCreateCoordinate() {
        Coordinate coordinate = new Coordinate(12.5, -34.789);
        assertEquals(12.5, coordinate.getLatitude());
        assertEquals(-34.789, coordinate.getLongitude());
    }
}