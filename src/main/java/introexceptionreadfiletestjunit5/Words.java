package introexceptionreadfiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Words {

    public String getFirstWordWithA(Path path) {
        for (String word : readWordsFromFile(path))
            if (word.startsWith("A"))
                return word;
        return "A";
    }

    private List<String> readWordsFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException exception) {
            System.err.println("cant read file");
        }
        return Collections.emptyList();
    }

}
