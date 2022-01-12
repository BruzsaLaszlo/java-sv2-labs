package searching;

import java.text.Collator;
import java.util.Locale;

public record Book(

        int id,
        String author,
        String title

) implements Comparable<Book> {

    public Book(String author, String title) {
        this(0, author, title);
    }

    @Override
    public int compareTo(Book o) {
        var collator = Collator.getInstance(new Locale("hu", "HU"));
        return author.equals(o.author) ? collator.compare(title, o.title) : collator.compare(author, o.author);
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

}
