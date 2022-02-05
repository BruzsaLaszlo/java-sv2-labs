package kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        validate(contacts, output);

        try (BufferedWriter out = Files.newBufferedWriter(Path.of(output))) {
            contacts.forEach((key, value) -> write(out, key, value));
        } catch (IOException e) {
            throw new IllegalArgumentException("cant write file");
        }
    }

    private void validate(Map<String, String> contacts, String output) {
        if (output == null || output.isBlank()) {
            throw new IllegalArgumentException("invalid output");
        }
        if (contacts == null) {
            throw new IllegalArgumentException("contact is null");
        }
    }

    private void write(BufferedWriter out, String key, String value) {
        try {
            out.write(key + ": " + value + "\n");
        } catch (IOException e) {
            throw new IllegalArgumentException("cant write contact");
        }
    }

}
