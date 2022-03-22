package zarovizsgapotvizsga2021.newspaper;

import java.util.List;

public class MainArticle extends Article {

    public MainArticle(String author, Header header, List<String> paragraphs) {
        super(author, header, paragraphs);
    }

    @Override
    int getImportance() {
        return getParagraphs().size() + getHeader().getLevel();
    }
}
