package zarovizsgapotvizsga.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class People {

    public int getNumberOfMales(String path) {
        return (int) getLinesFromFile(path).stream()
                .skip(1)
                .filter(line -> "Male".equals(line.split(",")[4]))
                .count();
    }

    private List<String> getLinesFromFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file " + path, e);
        }
    }

}
