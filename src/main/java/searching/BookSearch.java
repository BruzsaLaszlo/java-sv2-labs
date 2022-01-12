package searching;

import java.util.Collections;
import java.util.List;

public class BookSearch {

    private List<Book> books;

    public BookSearch(List<Book> books) {
        this.books = books;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (author == null || author.isBlank() || title == null || title.isBlank()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }

        Collections.sort(books);
        int found = Collections.binarySearch(books, new Book(author, title));

        if (found < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return books.get(found);
    }

}
