package interfacedefaultmethods;

import java.nio.file.Path;
import java.util.List;

public class LongWord implements FileOperations {

    @Override
    public String getLongWord() {
        List<String> lines = readFromFile(Path.of("src/test/resources/longword.txt"));
        StringBuilder sb = new StringBuilder(lines.get(0));
        for (int i = 1; i < lines.size(); i++) {
            sb.append(lines.get(i).substring(lines.get(i).length() - 1));
        }
        return sb.toString();
    }
}