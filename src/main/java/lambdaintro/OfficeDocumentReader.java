package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OfficeDocumentReader {

    public static final List<String> OFFICE_FILES = List.of("docx", "pptx", "xlsx");

    public List<File> listOfficeDocuments(File path) {
        if (!path.exists() || !path.isDirectory()) {
            throw new IllegalArgumentException("path is not exist or not directory");
        }

        var files = Objects.requireNonNull(path.listFiles(), "directory is empty");
        return Arrays.stream(files)
                .filter(File::isFile)
                .filter(this::isOfficeFile)
                .sorted(Comparator.comparing(File::getName))
                .toList();
    }

    private boolean isOfficeFile(File file) {
        if (file.getName().contains(".")) {
            int lastDotIndex = file.getName().lastIndexOf(".");
            String ext = file.getName().substring(lastDotIndex + 1);
            return OFFICE_FILES.contains(ext.toLowerCase());
        }
        return false;
    }

}
