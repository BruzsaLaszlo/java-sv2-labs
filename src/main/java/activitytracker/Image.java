package activitytracker;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Image {

    private long id;
    private String filename;
    private byte[] content;

    public Image(String filename) {
        this.filename = filename;
        Path path = Path.of("src/main/resources/activitytracker/" + filename);
        try {
            content = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalArgumentException("cant read file " + path, e);
        }
    }

    public Image(long id, String filename, InputStream inputStream) {
        this.id = id;
        this.filename = filename;
        try {
            this.content = new BufferedInputStream(inputStream).readAllBytes();
        } catch (IOException e) {
            throw new IllegalArgumentException("cant read blob", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Arrays.equals(content, image.content);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(content);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }
}
