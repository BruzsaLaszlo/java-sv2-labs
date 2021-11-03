package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PaulStreetBoys {

    public static void main(String[] args) {

        Path path = Path.of("./src/main/resources/palutcaifiuk.txt");
        PaulStreetBoys psb = new PaulStreetBoys();
        try {
            printNames(psb.readNamesFromFile(path));
        } catch (IllegalStateException ise) {
            System.err.println(ise.getMessage());
            ise.getCause().printStackTrace();
        }
    }

    private static void printNames (List<String> names){
        for (String name : names)
            if (name.equals("Nemecsek Ernő"))
                System.out.println(name.toLowerCase());
            else
                System.out.println(name);
    }

    public List<String> readNamesFromFile(Path path) {
        List<String> names;
        try {
            names = Files.readAllLines(path);
        } catch (IOException exception) {
            throw new IllegalStateException("cant read file", exception);
        }
        return names;
    }

}
