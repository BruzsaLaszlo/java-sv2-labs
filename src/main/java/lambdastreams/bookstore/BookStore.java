package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public long getNumberOfBooks() {
        return books.stream().count();
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparingInt(Book::yearOfPublish));
    }

    public int getTotalValue() {
        return books.stream()
                .map(book -> book.price() * book.piece())
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::yearOfPublish))
                .get(year);

    }

}
