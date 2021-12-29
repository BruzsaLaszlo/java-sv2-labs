package exceptions.measurement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Measurement {

    public List<String> validate(List<String> lines) {
        var result = new ArrayList<String>();

        for (String line : lines) {
            var data = line.split(",");

            if (!isDataValid(data)
                    || isNotNumber(data[0])
                    || isNotNumber(data[1])
                    || !isValidName(data[2])) {
                result.add(line);
            }
        }

        return result;
    }

    private boolean isDataValid(String[] data) {
        return data.length == 3;
    }

    private boolean isValidName(String name) {
        return name != null
                && !name.isBlank()
                && name.trim().indexOf(" ", 1) != -1;
    }

    private boolean isNotNumber(String number) {
        try {
            Double.parseDouble(number);
            return false;
        } catch (RuntimeException runtimeException) {
            return true;
        }
    }

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("invalid file name", e);
        }
    }
}
