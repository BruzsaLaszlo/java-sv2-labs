package kepesitovizsga.potvizsga.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {


    public int sumIgnoreComments(String path) {
        try {
            return Files.readAllLines(Path.of(path)).stream()
                    .filter(line -> !line.startsWith("//"))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (IOException e) {
            throw new IllegalArgumentException("can not read file " + path, e);
        }
    }
}
