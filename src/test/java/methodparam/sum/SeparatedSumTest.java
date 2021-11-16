package methodparam.sum;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void sum() throws IOException {

        SeparatedSum ss = new SeparatedSum();

        Path path = Path.of("src/main/resources/floatingnumbers.txt");

        Sums sums = ss.sum(Files.readString(path));

        assertEquals(-153.3, sums.getNegativeSum(),0.001);
        assertEquals(110.6, sums.getPositiveSum(),0.001);

    }
}