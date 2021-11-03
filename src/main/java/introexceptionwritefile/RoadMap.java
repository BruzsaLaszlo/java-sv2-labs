package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class RoadMap {

    public static void main(String[] args) {

        Path path = Path.of("./src/main/resources/roadmap.txt");
        List<String> roadMap = Arrays.asList("Kakucs", "Inárcs", "Ócsa", "Gyál");
        try {
            Files.write(path, roadMap);
        } catch (IOException exception) {
            System.out.println("cant write file");
        }

    }

}
