package algorithmstransformation.letters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LettersTest {

    @Test
    void getFirstTwoLetters() {

        List<String> words = Arrays.asList("EdClub", "Google", "Techpowerup", "firebase");
        List<String> expected = Arrays.asList("Ed", "Go", "Te", "fi");

        Letters letters = new Letters();
        List<String> result = letters.getFirstTwoLetters(words);
        assertLinesMatch(expected, result);

    }
}