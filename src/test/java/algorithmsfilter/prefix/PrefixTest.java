package algorithmsfilter.prefix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTest {

    @Test
    void getWordStartWith() {

        Prefix prefix = new Prefix();
        List<String> names = Arrays.asList("dr. Kovács", "Mr. Smith", "prof. Nagy", "Jancsika");

        List<String> list = prefix.getWordStartWith(names,"Mr.");
        assertEquals(1, list.size());
        assertEquals(false, list.contains("Jancsika"));
        assertEquals(true, list.contains("Mr. Smith"));

    }
}