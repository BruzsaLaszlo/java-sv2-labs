package kepesitovizsga.potpotvizsga;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(Path path) throws IOException {
        return (int) Files.readString(path).chars()
                .filter(Character::isUpperCase)
                .count();
    }
}
