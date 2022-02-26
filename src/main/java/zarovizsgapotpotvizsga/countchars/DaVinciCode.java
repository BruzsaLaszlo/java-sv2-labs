package zarovizsgapotpotvizsga.countchars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {

    public int encode(String path, char c) {
        if (c != '0' && c != '1' && c != 'x') {
            throw new IllegalArgumentException("invalid character");
        }

        return (int) getLinesFromFile(path).chars()
                .filter(value -> value == c)
                .count();
    }


    private String getLinesFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new IllegalArgumentException("cant read file");
        }
    }

}
