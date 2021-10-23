package attributes.book;

public class Book {

    private String title;

    public static void main(String[] args) {

        Book book = new Book("Java kezdőknek");

        System.out.println(book.getTitle());

        book.setTitle("Java haladóknak");

        System.out.println(book.getTitle());

    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
