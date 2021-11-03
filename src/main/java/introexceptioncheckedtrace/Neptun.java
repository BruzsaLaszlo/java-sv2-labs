package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Neptun {

    public static void main(String[] args) {

        String path = "./src/main/resources/neptun.csv";
        List<String> codes = new ArrayList<>();
        try {
            for (String line : new Neptun().readFile(path))
                codes.add(line.split(",")[1]);
        } catch (IOException exception) {
            System.err.println("File cant read");
        }
        System.out.println(codes);

    }

    private List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }

}
