package classstructuremethods;

import java.security.SecureRandom;

/**
Hozz létre egy Client osztályt, melynek három private attribútuma van: név (name), születési év (year) és cím (address).
Típusaik rendre String, int és String!

Mind a három attribútumra legyen lekérdező és módosító metódus! Legyen egy public void migrate(String address) metódusa is,
mely az ügyfél elköltözését implementálja, valójában beállítja a tárolt címet az új, paraméterként átadott címre.
 */
public class Client {
    private String name;
    private int year;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void migrate(String address){
        this.address = address;
    }
}
