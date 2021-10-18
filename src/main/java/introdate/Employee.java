package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDateTime beginEmployment;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getBeginEmployment() {
        return beginEmployment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(int year, int month, int day, String name) {
        dateOfBirth = LocalDate.of(year, month, day);
        this.name = name;
        beginEmployment = LocalDateTime.now();
    }
}
