package collectionslist.expirationdate;

import java.time.LocalDate;

public class Food {

    private String name;
    private LocalDate expiration;

    public Food(String name, LocalDate expiration) {
        this.name = name;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiration() {
        return expiration;
    }
}
