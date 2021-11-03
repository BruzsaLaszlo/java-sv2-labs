package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Books {

    public static final Path PATH = Path.of("./src/main/resources/books.txt");

    public List<String> getBetterBooks() throws IOException {
        List<String> betterBooks = new ArrayList<>();
        for (String book : Files.readAllLines(PATH)){
            String[] b = book.split(";");
            betterBooks.add(b[2] + ": " + b[1]);
        }
        return betterBooks;
    }

    public void writeBetterBooks(Path path) throws IOException {
        Files.write(path, getBetterBooks());
    }

}
