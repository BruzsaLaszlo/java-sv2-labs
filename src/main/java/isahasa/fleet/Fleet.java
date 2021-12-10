package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPeople;
    private int waitingCargo;


    public void addShip(Ship newShip) {
        ships.add(newShip);
    }

    public void loadShip(int passengers, int cargoWeight) {
        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers canCarryPassengers) {
                passengers = canCarryPassengers.loadPassenger(passengers);
            }
            if (ship instanceof CanCarryGoods canCarryGoods) {
                cargoWeight = canCarryGoods.loadCargo(cargoWeight);
            }
        }
        waitingCargo = cargoWeight;
        waitingPeople = passengers;
    }

    public int getWaitingPeople() {
        return waitingPeople;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

}
