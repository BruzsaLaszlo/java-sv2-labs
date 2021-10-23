package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VowelsTest {

    @Test
    void getNumberOfVowels() {

        Vowels vowels = new Vowels();
        assertEquals(2,vowels.getNumberOfVowels("abcdef"));
        assertEquals(0,vowels.getNumberOfVowels("qwrty"));
        assertEquals(5,vowels.getNumberOfVowels("aeiou"));

    }
}