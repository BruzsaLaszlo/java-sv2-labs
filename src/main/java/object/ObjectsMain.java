package object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {

        class Book {}

        new Book();

        System.out.println(new Book());

        Book emptyBook;
        emptyBook = null;
        System.out.println(emptyBook);
        if (emptyBook == null)
            System.out.println("igen, null");
        else
            System.out.println("nem, nem null");

        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);

        Book anotherBook = new Book();
        System.out.println(book == anotherBook);
        anotherBook = book;
        System.out.println(book == anotherBook);



        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book6;
        new Book();
        book5 = new Book();
        book6 = null;
        book5 = book4;

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
        System.out.println(book6);
        System.out.println(book7);


        Book[] books = {
                new Book(),
                new Book(),
                new Book()
        };

        List<Book> bookList = Arrays.asList(
                new Book(),
                new Book(),
                new Book()
        );

        List<Book> bookList1 = new ArrayList<>();
        bookList1.add(new Book());
        bookList1.add(new Book());
        bookList1.add(new Book());

        System.out.println(Arrays.toString(books));
        System.out.println(bookList);
        System.out.println(bookList1);

    }
}
