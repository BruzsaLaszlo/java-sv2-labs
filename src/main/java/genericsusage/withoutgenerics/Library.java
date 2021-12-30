package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;
import java.util.Objects;

public class Library {

    public Book getFirstBook(List books) {
        Objects.requireNonNull(books, "books can not be null!");
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }

        if (books.get(0) instanceof Book book) {
            return book;
        }
        throw new ClassCastException("Not a book");
    }

}
