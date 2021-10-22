package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeeksTest {

    @Test
    void getDayOfWhat() {

        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        assertEquals("hét közepe", dayOfWeeks.getDayOfWhat("KeDD"));
        assertEquals("hét vége", dayOfWeeks.getDayOfWhat("Szombat"));
        assertEquals("ismeretlen nap", dayOfWeeks.getDayOfWhat("Monday"));

    }
}