package primitivetypes.exam;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate birthDate;
    private int zipNumber;
    private double averageRating;

    public Person(String name, LocalDate birthDate, int zipNumber, double averageRating) {
        this.name = name;
        this.birthDate = birthDate;
        this.zipNumber = zipNumber;
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return  "név: '" + name + '\'' +
                ", születési idő: " + birthDate +
                ", irányítószám: " + zipNumber +
                ", átlagosztályzat: " + averageRating;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getZipNumber() {
        return zipNumber;
    }

    public double getAverageRating() {
        return averageRating;
    }
}
