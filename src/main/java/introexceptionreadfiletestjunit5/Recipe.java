package introexceptionreadfiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private List<String> ingredients = new ArrayList<>();

    public void addIngredients(Path path) {
        for (String line : readRecipe(path)) {
            String[] s = line.split(" ");
            if (s.length == 3)
                ingredients.add(s[2]);
        }
    }

    private List<String> readRecipe(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("no file", ioe);
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
