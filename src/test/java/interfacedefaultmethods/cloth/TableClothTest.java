package interfacedefaultmethods.cloth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableClothTest {

    TableCloth tableCloth = new TableCloth(4);

    @Test
    void getNumberOfSides() {
        assertEquals(4.0,tableCloth.getNumberOfSides());
    }

    @Test
    void getLengthOfDiagonal() {
        assertEquals(5.6, tableCloth.getLengthOfDiagonal(),0.1);
    }

    @Test
    void getPerimeter() {
        assertEquals(16, tableCloth.getPerimeter());
    }

    @Test
    void getArea() {
        assertEquals(16, tableCloth.getArea());
    }

    @Test
    void getSide() {
        assertEquals(4, tableCloth.getSide());
    }
}