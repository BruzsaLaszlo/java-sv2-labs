package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Electricity {

    public List<String> getStreets() {
        return Arrays.asList(LocalDate.now().toString(),"Petőfi", "Kossuth","Szép", "Fő", "Birsalma");
    }

    public void writeStreets(Path path) throws IOException {
        Files.write(path, getStreets());
    }
}
