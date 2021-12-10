package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers{

    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int dif = maxPassengers - this.passengers - passengers;
        if (dif < 0) {
            this.passengers = maxPassengers;
            return -dif;
        } else {
            this.passengers += passengers;
            return 0;
        }
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
