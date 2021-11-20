package dynamictypes.publictransport;

public class Tram extends PublicVehicle {

    private int numberOfTramcars;

    public Tram(int lineNumber, double lenght, int numberOfTramcars) {
        super(lineNumber, lenght);
        this.numberOfTramcars = numberOfTramcars;
    }

    public int getNumberOfTramcars() {
        return numberOfTramcars;
    }
}
