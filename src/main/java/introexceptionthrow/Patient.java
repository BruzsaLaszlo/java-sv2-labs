package introexceptionthrow;

import java.time.LocalDate;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name.isBlank())
            throw new IllegalArgumentException("name is blank");
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        if (yearOfBirth < 1900)
            throw new IllegalArgumentException("you cant be older than " + (LocalDate.now().getYear() - 1900));
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {

        try {
            new Patient("", "123 456 789", 1999);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            new Patient("Pisti bácsi", "123 456 789", 1899);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
