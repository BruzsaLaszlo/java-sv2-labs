package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class Operation {

    public List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }

    public String getDailySchedule(List<String> numberOfMetroTrain) {
        StringBuilder sb = new StringBuilder(LocalDate.now() + ",");
        for (String s : numberOfMetroTrain)
            if (s.startsWith("2"))
                sb.append(" ").append(s);
        return sb.toString();
    }

}
