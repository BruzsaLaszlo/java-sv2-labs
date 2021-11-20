package inheritancemethods.plane;

public class PriorityPassenger extends Passenger {

    private final int percent;

    public PriorityPassenger(String name, int priceOfPlaneTicket, int percent) {
        super(name, priceOfPlaneTicket);
        this.percent = percent;
    }

    @Override
    public int getPriceOfPlaneTicket() {
        return super.getPriceOfPlaneTicket() + (int) (super.getPriceOfPlaneTicket() * (percent / 100d));
    }

    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                ", priceOfPlaneTicket=" + getPriceOfPlaneTicket();
    }
}
