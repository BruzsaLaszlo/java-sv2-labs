package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifiedWordTest {

    @Test
    void modify() {

        ModifiedWord mw = new ModifiedWord();

        assertEquals("AxMy", mw.modify("alma"));
        assertEquals("KxRy", mw.modify("körte"));
        assertEquals("SxIy", mw.modify("szilva"));
        assertThrows(IllegalArgumentException.class, () -> mw.modify("szi"));

    }
}