package defaultconstructor.date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleDateTest {


    @Test
    void incorrectParameterShouldThrowExceptionNotALeapYear() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> sd.setDate(1914, 2, 29));

        assertEquals("invalid day: 29", ex.getMessage());
    }

    @Test
    void incorrectParameterShouldThrowExceptionDayIncorrect() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> sd.setDate(2000, 4, 31));

        assertEquals("invalid day: 31", ex.getMessage());
    }

    @Test
    void incorrectParameterShouldThrowExceptionYearIncorrect() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> sd.setDate(1848, 3, 15));

        assertEquals("invalid year: 1848", ex.getMessage());
    }

    @Test
    void incorrectParameterShouldThrowExceptionMonthIncorrect() throws IllegalArgumentException {
        SimpleDate sd = new SimpleDate();

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> sd.setDate(2014, 13, 15));

        assertEquals("invalid month: 13", ex.getMessage());
    }

    @Test
    void testSetDate() {
        SimpleDate date = new SimpleDate();
        date.setDate(2016, 2, 29);
        assertEquals(2016, date.getYear());
        assertEquals(2, date.getMonth());
        assertEquals(29, date.getDay());
    }
}