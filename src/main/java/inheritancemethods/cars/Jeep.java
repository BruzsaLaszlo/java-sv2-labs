package inheritancemethods.cars;

public class Jeep extends Car {

    private double extraFuel;
    private final double extraCapacity;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel <= extraCapacity) {
            this.extraFuel = extraFuel;
            this.extraCapacity = extraCapacity;
        } else {
            throw new IllegalArgumentException("invalid fuel");
        }
    }

    @Override
    public void modifyFuelAmount(double fuel) {

        if (fuel < 0) {
            burnFuel(fuel);
        } else {
            addFuel(fuel);
        }

    }

    private void addFuel(double fuel) {
        if (fuel > calculateRefillAmount()) {
            throw new IllegalStateException("Not enough capacity!");
        } else {
            double f = fuel - super.calculateRefillAmount();
            if (f > 0) {
                super.modifyFuelAmount(super.calculateRefillAmount());
                extraFuel += f;
            } else {
                super.modifyFuelAmount(f);
            }
        }
    }

    private void burnFuel(double fuel) {
        double f = extraFuel + fuel;
        if (f < 0) {
            extraFuel = 0;
            super.modifyFuelAmount(f);
        } else {
            extraFuel -= fuel;
        }
    }

    @Override
    public void drive(int km) {
        modifyFuelAmount(-super.fuelUsed(km));
    }

    @Override
    public double calculateRefillAmount() {
        return getTankCapacity() + extraCapacity - getFuel() - extraFuel;
    } //kiszámolja, mennyit lehet tankolni

    public double getExtraFuel() {
        return extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }
}
