package compositionlist;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private List<String> titles = new ArrayList<>();

    public void addBook(String title) {
        titles.add(title);
    }

    public void findBookAndSetAuthor(String title, String author) {
        titles.set(titles.indexOf(title), title + ": " + author);
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {

        Book book = new Book();

        book.addBook("In Search of Lost Time");
        book.addBook("Ulysses");
        book.addBook("Don Quixote");
        book.addBook("One Hundred Years of Solitude");
        book.addBook("The Great Gatsby");
        System.out.println(book.getTitles());

        book.findBookAndSetAuthor("Don Quixote", "Miguel de Cervantes");
        System.out.println(book.getTitles());

    }

}
