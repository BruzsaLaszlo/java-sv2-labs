package introexceptionthrow;

public class Validation {

    public void validateName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("a megadott név null értékű vagy üres");
    }

    public int validateAge(String ageString) {
        if (ageString.isBlank())
            throw new IllegalArgumentException("nem adtál meg semmit");

        int age;
        try {
            age = Integer.parseInt(ageString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("nem számot adtál meg");
        }

        if (age < 0 || age > 120)
            throw new IllegalArgumentException("túl öreg vagy / meg sem születtél");

        return age;
    }

}
