package projects.catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (numberOfPages < 1 || Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("invalid parameters");
        }
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        return List.copyOf(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
