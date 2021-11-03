package introexceptionthrow.patient;

public class Patient extends introexceptionthrow.Patient {

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        super(name, socialSecurityNumber, yearOfBirth);
        if (!new SsnValidator().isValidSsn(socialSecurityNumber))
            throw new IllegalArgumentException("invalid SSN, name: " + name);
    }


    public static void main(String[] args) {

        try {
            new Patient("Pisti", "123 456 788", 1999);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            new Patient("Annamária", "111 111 11o", 2002);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            new Patient("Jancsi", "123 456 789", 1988);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }

    }


}
