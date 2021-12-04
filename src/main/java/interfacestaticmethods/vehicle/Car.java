package interfacestaticmethods.vehicle;

public class Car implements Vehicle {

    private String brand;
    private int numberOfWheels;

    public Car(String brand, int numberOfWheels) {
        this.brand = brand;
        this.numberOfWheels = numberOfWheels;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public Car setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
        return this;
    }
}
