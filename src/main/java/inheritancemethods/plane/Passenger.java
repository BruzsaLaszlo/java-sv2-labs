package inheritancemethods.plane;

public class Passenger {

    private final String name;
    private final int priceOfPlaneTicket;

    public Passenger(String name, int priceOfPlaneTicket) {
        this.name = name;
        this.priceOfPlaneTicket = priceOfPlaneTicket;
    }

    public String getName() {
        return name;
    }

    public int getPriceOfPlaneTicket() {
        return priceOfPlaneTicket;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", priceOfPlaneTicket=" + priceOfPlaneTicket;
    }
}
