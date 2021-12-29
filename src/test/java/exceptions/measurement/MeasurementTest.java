package exceptions.measurement;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    Measurement m = new Measurement();
    Path path = Path.of("src/main/resources/measurementdata.csv");

    @Test
    void validate() {

        var lines = m.readFromFile(path);
        assertEquals(lines.size() - 3, m.validate(lines).size());

    }

    @Test
    void readFromFile() {

        var invalidPath = Path.of("___");
        assertThrows(IllegalStateException.class, ()-> m.readFromFile(invalidPath));

        assertDoesNotThrow(()-> m.readFromFile(path));

    }
}