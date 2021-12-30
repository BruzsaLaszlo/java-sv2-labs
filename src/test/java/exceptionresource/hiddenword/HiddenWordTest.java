package exceptionresource.hiddenword;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class HiddenWordTest {

    @Test
    void getHiddenWord() {

        HiddenWord hiddenWord = new HiddenWord();
        Path path   = Path.of("src/test/resources/hiddenword.txt");

        assertEquals("ALMA KÖRTE", hiddenWord.getHiddenWord(path));

    }
}