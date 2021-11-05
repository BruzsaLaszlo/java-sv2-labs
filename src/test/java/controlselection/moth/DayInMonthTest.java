package controlselection.moth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayInMonthTest {

    @Test
    void getDayInMonth() {

        DayInMonth dayInMonth = new DayInMonth();

        assertEquals(29, dayInMonth.getDayInMonth(2000,"Február"));
        assertEquals(28, dayInMonth.getDayInMonth(1900,"FEBRUár"));
        assertEquals(30, dayInMonth.getDayInMonth(2021,"november"));
        assertEquals(31, dayInMonth.getDayInMonth(2021,"Május"));

    }
}