package constructoroverloading.advertisement;

import java.util.Collections;
import java.util.List;

public class BikeAdvertisement {

    private String shortDescription;
    private double price;
    private List<String> extras;
    private String brand;
    private String serialNumber;

    public BikeAdvertisement(String shortDescription, double price) {
        this(shortDescription,price, Collections.emptyList(),"","");
    }

    public BikeAdvertisement(String shortDescription, double price, String brand) {
        this(shortDescription,price, Collections.emptyList(),brand,"");
    }

    public BikeAdvertisement(String shortDescription, double price, List<String> extras, String brand) {
        this(shortDescription,price, extras,brand,"");
    }

    public BikeAdvertisement(String shortDescription, double price, List<String> extras, String brand, String serialNumber) {
        this.shortDescription = shortDescription;
        this.price = price;
        this.extras = extras;
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

}
