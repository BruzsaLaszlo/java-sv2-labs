package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Poem {

    public static void main(String[] args) {

        Poem poem = new Poem();
        Path path = Path.of("./src/main/resources/poem.txt");
        StringBuilder sb = new StringBuilder();
        try {
            for (String s : poem.readPoem(path))
                sb.append(s.charAt(0));
            System.out.println(sb);
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
            exception.getCause().printStackTrace();
        }

    }

    public List<String> readPoem(Path path) {
        List<String> poem;
        try {
            poem = Files.readAllLines(path);
        } catch (IOException ioException) {
            throw new IllegalStateException("cant read file", ioException);
        }
        return poem;
    }

}
