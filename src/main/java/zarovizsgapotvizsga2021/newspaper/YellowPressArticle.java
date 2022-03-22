package zarovizsgapotvizsga2021.newspaper;

import java.util.List;

public class YellowPressArticle extends Article {

    public YellowPressArticle(String author, Header header, List<String> paragraphs) {
        super(author, header, paragraphs);
        validate(header);
    }

    private void validate(Header header) {
        if (header.getLevel() > 5) {
            throw new IllegalArgumentException("Header size cannot be greater than 5!");
        }
    }

    @Override
    int getImportance() {
        return 1;
    }
}
