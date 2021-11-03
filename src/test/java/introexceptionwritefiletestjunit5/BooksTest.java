package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    @TempDir
    File tempdir;

    @Test
    void writeBetterBooks() throws IOException {

        Path path = tempdir.toPath().resolve("betterbooks.txt");
        Books books = new Books();

        books.writeBetterBooks(path);
        assertEquals(books.getBetterBooks(), Files.readAllLines(path));


    }
}