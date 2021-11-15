package immutable;

import java.time.LocalDate;

public class Car {

    private final String brand;
    private final String typeName;
    private final int yearOfManufacture;

    public Car(String brand, String typeName, int yearOfManufacture) {

        if (brand == null || brand.isBlank())
            throw new IllegalArgumentException("A brand nem lehet null vagy üres!");

        if (yearOfManufacture > LocalDate.now().getYear())
            throw new IllegalArgumentException("Hibás az év!");

        this.brand = brand;
        this.typeName = typeName;
        this.yearOfManufacture = yearOfManufacture;
    }

}
