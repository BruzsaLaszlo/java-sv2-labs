package dynamictypes.publictransport;

public class Bus extends PublicVehicle {

    private String brand;

    public Bus(int lineNumber, double lenght, String brand) {
        super(lineNumber, lenght);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
