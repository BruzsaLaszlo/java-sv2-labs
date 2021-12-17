package virtualmethod.vehicle;

public class FerryBoat extends Vehicle {

    private Car car;

    public static final int MAX_CARRY_WEIGTH = 1700;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }


    public boolean canCarry(Car car) {
        return MAX_CARRY_WEIGTH >= car.getGrossLoad();
    }

    public boolean load(Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public int getGrossLoad() {
        return car.getGrossLoad() + getVehicleWeight() + PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return "FerryBoat{" +
                "car=" + car +
                '}';
    }
}
