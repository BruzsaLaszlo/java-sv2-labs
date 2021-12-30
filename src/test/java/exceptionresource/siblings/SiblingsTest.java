package exceptionresource.siblings;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SiblingsTest {

    @Test
    void getFullNames() {

        Siblings siblings = new Siblings();
        Path path = Path.of("src/test/resources/siblings.txt");

        var expected = List.of("Szabó Emese", "Szabó Ferenc");
        assertEquals(expected, siblings.getFullNames("Szabó", path));


    }
}