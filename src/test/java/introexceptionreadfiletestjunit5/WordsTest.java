package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    @Test
    void getFirstWordWithA() {

        Words words = new Words();

        Path path = Path.of("./src/main/resources/words.txt");
        assertEquals("Anna",words.getFirstWordWithA(path));

        path = Path.of("./src/main/resources/words2.txt");
        assertEquals("A",words.getFirstWordWithA(path));


    }
}