package introexceptionfinally;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Names {

    public static void main(String[] args) {

        Names names = new Names();

        Path path1 = Path.of("./src/main/resources/names.txt");
        names.getNameStartsWithDr(path1);

        Path path2 = Path.of("./src/main/resources/names2.txt");
        names.getNameStartsWithDr(path2);

        Path path3 = Path.of("./src/main/resources/123456789xyz.txt");
        names.getNameStartsWithDr(path3);

    }

    public void getNameStartsWithDr(Path path) {
        try {
            for (String name : Files.readAllLines(path))
                if (name.startsWith("dr")) {
                    System.out.println(name);
                    return;
                }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("End of reading.");
        }
    }

}
