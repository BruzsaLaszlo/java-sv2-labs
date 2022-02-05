package kepesitovizsga.potpotvizsga;

import kepesitovizsgapotpotvizsga.UpperCaseLetters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

class UpperCaseLettersTest {

    @Test
    void testGetNumberOfUpperCase() throws IOException {
        Assertions.assertEquals(8, new UpperCaseLetters().getNumberOfUpperCase(Path.of("src/main/resources/characters.txt")));
    }
}