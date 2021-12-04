package interfacedefaultmethods.seats;

public class Car implements Seat {

    private String brand;
    private int numberOfSeats;

    public Car(String brand, int numberOfSeats) {
        this.brand = brand;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getBrand() {
        return brand;
    }
}
