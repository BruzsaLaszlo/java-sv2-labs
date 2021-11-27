package inheritancemethods.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (validateFuel(fuel, tankCapacity)) {
            this.fuelRate = fuelRate;
            this.fuel = fuel;
            this.tankCapacity = tankCapacity;
        }
    }

    private boolean validateFuel(double fuel) {
        return validateFuel(fuel, tankCapacity);
    }

    private boolean validateFuel(double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        return true;
    }

    public void modifyFuelAmount(double fuel) {
        if (validateFuel(fuel)) {
            this.fuel += fuel;
        }
    }

    /**
     * csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
     */
    public void drive(int km) {
        modifyFuelAmount(-fuelUsed(km));
    }

    protected double fuelUsed(int km) {
        double used = fuelRate * (km / 100d);
        if (used > fuel) {
            throw new IllegalStateException("Not enough fuel available!");
        }
        return used;
    }

    /**
     * kiszámolja, mennyit lehet tankolni
     */
    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }
}
