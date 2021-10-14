package classstructureconstructors;

import jdk.jshell.spi.SPIResolutionException;

/*
Hozz létre egy Book osztályt, melynek három privát attribútuma van: szerző (author), cím (title) és
regisztrációs szám (regNumber), mindhárom típusa String.

A Book példányosításakor csak a szerzőt és a címet kelljen megadni.

Legyen egy public void register(String regNumber) metódusa,
mely a nyilvántartásba vételt implementálja, és ennek paraméterül kell megadni a regisztrációs számot.
 */
public class Book {

    private String author;
    private String title;
    private String regNumber;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void register(String regNumber) {
        this.regNumber = regNumber;
    }
}
