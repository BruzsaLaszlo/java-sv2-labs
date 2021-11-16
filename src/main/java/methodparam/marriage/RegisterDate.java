package methodparam.marriage;

import java.time.LocalDate;

public class RegisterDate {

    private String decription;

    private LocalDate date;

    public RegisterDate(String decription, LocalDate date) {
        this.decription = decription;
        this.date = date;
    }

    public String getDecription() {
        return decription;
    }

    public LocalDate getDate() {
        return date;
    }
}
