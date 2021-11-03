package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ElectricityTest {

    @TempDir
    File tempfolder;

    @Test
    void writeStreets() throws IOException {

        Path path = tempfolder.toPath().resolve("streets.txt");
        Electricity electricity = new Electricity();

        electricity.writeStreets(path);
        assertEquals(electricity.getStreets(), Files.readAllLines(path));


    }
}