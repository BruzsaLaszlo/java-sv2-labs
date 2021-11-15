package immutable;

import java.time.LocalDate;

public class Monument {

    private final String name;
    private final String address;
    private final LocalDate registrationDate;
    private final String registrationNumber;

    public Monument(String name, String address, LocalDate registrationDate, String registrationNumber) {

        if (isEmpty(name) || isEmpty(address) || isEmpty(registrationNumber))
            throw new IllegalArgumentException("Parameters can not be null!");

        this.name = name;
        this.address = address;
        this.registrationDate = registrationDate;
        this.registrationNumber = registrationNumber;
    }

    private boolean isEmpty(String string) {
        return name == null || name.isBlank();
    }

}
