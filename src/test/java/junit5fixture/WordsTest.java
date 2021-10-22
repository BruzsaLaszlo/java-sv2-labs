package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    Words  words;

    @BeforeEach
    void setUp() {

        words = new Words();
        words.addWord("alma");
        words.addWord("eper");
        words.addWord("meggy");
        words.addWord("banán");
        words.addWord("körte");
        words.addWord("barack");
        words.addWord("birsalma");

    }

    @Test
    void testRemoveWordStartWith() {

        List<String> testList = Arrays.asList("alma", "eper", "meggy", "körte");
        words.removeWordStartWith("b");
        assertEquals(testList, words.getWords());

    }

    @Test
    void testRemoveWordsWithLength() {

        List<String> testList = Arrays.asList("alma", "eper", "barack", "birsalma");
        words.removeWordsWithLength(5);
        assertEquals(testList, words.getWords());

    }
}