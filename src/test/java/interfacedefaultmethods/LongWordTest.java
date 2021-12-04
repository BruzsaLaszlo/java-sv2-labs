package interfacedefaultmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongWordTest {

    @Test
    void getLongWord() {

        LongWord lw = new LongWord();
        assertEquals("LONGWORD", lw.getLongWord());

    }
}