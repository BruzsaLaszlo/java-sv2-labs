package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void addIngredients() {

        Recipe recipe = new Recipe();
        Path path = Path.of("./src/main/resources/recipe.txt");
        recipe.addIngredients(path);

        List<String> expectedIngredients = Arrays.asList(
                "liszt",
                "margarin",
                "kristálycukor",
                "tojás",
                "citrom",
                "sütőpor",
                "vanillincukor",
                "tejföl",
                "alma",
                "fahéj");
        assertEquals(expectedIngredients,recipe.getIngredients());

    }
}