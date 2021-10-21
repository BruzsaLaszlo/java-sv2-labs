package classstructureconstructors;

/*
Írj egy main() metódust a BookMain osztályba, amivel kipróbálod a működését!
Az attribútumok kiolvasásához használj gettereket!
 */
public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Лев Николаевич Толстой","Война и миръ");
        book.register("9630796088");

        System.out.println(book.getAuthor() + " - " + book.getTitle() + " (reg:" + book.getRegNumber() + ")");

    }

}
