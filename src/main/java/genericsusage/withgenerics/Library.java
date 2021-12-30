package genericsusage.withgenerics;

import genericsusage.Book;

import java.util.List;
import java.util.Objects;

public class Library {

    public Book getFirstBook(List<Book> books) {
        Objects.requireNonNull(books, "books can not be null!");
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }

        return books.get(0);
    }

}
