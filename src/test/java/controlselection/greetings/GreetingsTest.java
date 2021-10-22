package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @Test
    void testGetGtreeting() {

        Greetings greetings = new Greetings();
        assertEquals("Jó napot!", greetings.getGtreeting(18, 29));
        assertEquals("Jó estét!", greetings.getGtreeting(18,31));
        assertEquals("Jó éjszakát!", greetings.getGtreeting(20,0));
        assertEquals("Jó reggelt!", greetings.getGtreeting(8,0));

    }
}