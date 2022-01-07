package projects.catalog;

public class SearchCriteria {

    private String contributor;
    private String title;


    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("title can not be empty");
        }
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("contributor can not be empty");
        }
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("title can not be empty");
        }
        return new SearchCriteria(title, null);
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    private SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
