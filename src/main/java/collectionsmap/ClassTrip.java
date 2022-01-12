package collectionsmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ClassTrip {

    private Map<String, Integer> inpayments;

    public void loadInpayments(Path path) {
        inpayments = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                var data = reader.readLine().split(": ");
                inpayments.put(data[0], Integer.parseInt(data[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public Map<String, Integer> getInpayments() {
        return Map.copyOf(inpayments);
    }
}
