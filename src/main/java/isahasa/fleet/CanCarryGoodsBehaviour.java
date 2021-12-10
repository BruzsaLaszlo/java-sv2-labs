package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods{

    private int cargoWeight;
    private int maxCargoWeigth;

    public CanCarryGoodsBehaviour(int maxCargoWeigth) {
        this.maxCargoWeigth = maxCargoWeigth;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        int dif = maxCargoWeigth - this.cargoWeight - cargoWeight;
        if (dif < 0) {
            this.cargoWeight = maxCargoWeigth;
            return -dif;
        } else {
            this.cargoWeight += cargoWeight;
            return 0;
        }
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }
}
