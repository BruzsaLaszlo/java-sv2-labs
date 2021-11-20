package dynamictypes.publictransport;

public class PublicVehicle {

    private int lineNumber;
    private double lenght;

    public PublicVehicle(int lineNumber, double lenght) {
        this.lineNumber = lineNumber;
        this.lenght = lenght;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public double getLenght() {
        return lenght;
    }
}
