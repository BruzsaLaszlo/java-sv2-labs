package searching;

import java.time.LocalDate;
import java.util.Objects;

public class LostProperty implements Comparable<LostProperty> {

    private String registrationNumber;
    private String description;
    private LocalDate date;

    public LostProperty(String description) {
        this.description = description;
    }

    public LostProperty(String registrationNumber, String description, LocalDate date) {
        this(description);
        this.registrationNumber = registrationNumber;
        this.date = date;
    }

    public LostProperty(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public int compareTo(LostProperty o) {
        return description.equals(o.description) ? date.compareTo(o.date) : description.compareTo(o.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LostProperty that = (LostProperty) o;
        return Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }

    public String getRegNumber() {
        return registrationNumber;
    }

    public String getDescription() {
        return description;
    }
}
