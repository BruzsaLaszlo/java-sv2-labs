package zarovizsgapotvizsga2021.newspaper;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NewsPaper {

    private String name;
    private Set<Article> articles = new TreeSet<>();

    public NewsPaper(String name) {
        this.name = name;
    }

    public List<Article> findArticlesByAuthor(String author) {
        return articles.stream()
                .filter(article -> article.getAuthor().equals(author))
                .toList();
    }

    public List<Article> findArticleByParagraphPart(String text) {
        return articles.stream()
                .filter(article -> isParagraphContainsText(article.getParagraphs(), text))
                .toList();
    }

    private boolean isParagraphContainsText(List<String> paragraphs, String text) {
        return paragraphs.stream()
                .anyMatch(p -> p.contains(text));
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return Collections.unmodifiableSet(articles);
    }
}
