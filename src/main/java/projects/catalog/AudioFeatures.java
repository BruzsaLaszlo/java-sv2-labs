package projects.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AudioFeatures implements Feature {

    private final List<String> composers;
    private int length;
    private final List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composers) {
        if (Validators.isBlank(title) || length < 1 || Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("invalid parameters");
        }
        this.composers = composers;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers, Collections.emptyList());
    }

    @Override
    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        result.addAll(composers);
        result.addAll(performers);
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
