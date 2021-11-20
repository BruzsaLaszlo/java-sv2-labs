package dynamictypes.publictransport;

public class Metro extends PublicVehicle {

    private int numberOfStations;

    public Metro(int lineNumber, double lenght, int numberOfStations) {
        super(lineNumber, lenght);
        this.numberOfStations = numberOfStations;
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }
}
