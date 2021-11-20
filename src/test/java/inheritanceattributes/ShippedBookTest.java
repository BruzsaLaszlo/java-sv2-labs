package inheritanceattributes;

import inheritanceattributes.book.ShippedBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippedBookTest {

    @Test
    void constructorAndToStringTest() {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals("Gyűrűk ura: 3000 Ft, postaköltség: 1200 Ft",book.toString());
    }

    @Test
    void orderTest()  {
        //Given
        ShippedBook book = new ShippedBook("Gyűrűk ura", 3000, 1200);
        //Then
        assertEquals(7200,book.orderSize(2));
    }

}