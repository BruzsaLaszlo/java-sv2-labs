package zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        String result = null;
        int min = Integer.MAX_VALUE;
        for (String line : readFromFile(file)) {
            var data = line.split(",");
            int hour = Integer.parseInt(data[1]);
            if (hour < min) {
                min = hour;
                result = data[0] + ": " + data[2];
            }
        }
        return result;
    }

    private List<String> readFromFile(String file) {
        try {
            return Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            throw new IllegalArgumentException("cant read file " + file, e);
        }
    }
}
