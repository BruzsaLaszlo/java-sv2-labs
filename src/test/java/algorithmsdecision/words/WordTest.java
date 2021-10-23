package algorithmsdecision.words;

import algorithmsdecision.words.Word;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void containsLongerWord() {

        Word word = new Word();
        List<String> words = Arrays.asList(
                "feladat", "java", "tételek", "összegzés", "gyakorlatias");

        assertEquals(false, word.containsLongerWord(words,"megszámlálhatatlanság"));
        assertEquals(true, word.containsLongerWord(words,"véges"));

    }
}