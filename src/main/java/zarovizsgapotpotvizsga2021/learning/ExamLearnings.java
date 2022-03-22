package zarovizsgapotpotvizsga2021.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExamLearnings {

    private Map<String, Double> learnings = Collections.emptyMap();

    public double getAverageLearningInMinutes() {
        return learnings.values().stream()
                .mapToDouble(value -> value)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("There are no learning times."));
    }

    public void readFromFile(Path path) {
        learnings = getLinesFromFile(path).stream()
                .collect(Collectors.toMap(this::getName, this::getTime));
    }

    private String getName(String line) {
        return line.split(";")[0];
    }

    private Double getTime(String line) {
        return Arrays.stream(line.split(";"))
                .skip(1)
                .mapToDouble(value -> Double.parseDouble(value.replace(',', '.')) * 60)
                .sum();
    }

    private List<String> getLinesFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    public Map<String, Double> getLearnings() {
        return Collections.unmodifiableMap(learnings);
    }
}
