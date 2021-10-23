package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void isPalindrome() {

        Palindrome palindrome = new Palindrome();
        assertEquals(false, palindrome.isPalindrome("Aibohphobia"));
        assertEquals(false, palindrome.isPalindrome("aibohPphobia"));
        assertEquals(true, palindrome.isPalindrome("aibohphobia"));

    }
}