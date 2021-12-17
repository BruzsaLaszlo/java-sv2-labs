package virtualmethod.vehicle;

public class Van extends Car {

    private int cargoWeigth;

    public Van(int numberOfPassenger, int vehicleWeight, int cargoWeigth) {
        super(vehicleWeight, numberOfPassenger);
        this.cargoWeigth = cargoWeigth;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + cargoWeigth;
    }

    @Override
    public String toString() {
        return "Van{" +
                "cargoWeight=" + cargoWeigth +
                ", numberOfPassenger=" + numberOfPassenger +
                ", vehicleWeight=" + getVehicleWeight()+
                '}';
    }
}
