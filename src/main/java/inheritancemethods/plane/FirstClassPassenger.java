package inheritancemethods.plane;

public class FirstClassPassenger extends PriorityPassenger {

    private int extraCharge = 20_000;

    public FirstClassPassenger(String name, int priceOfPlaneTicket, int percent) {
        super(name, priceOfPlaneTicket, percent);
    }

    @Override
    public int getPriceOfPlaneTicket() {
        return super.getPriceOfPlaneTicket() + extraCharge;
    }

    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                ", priceOfPlaneTicket=" + getPriceOfPlaneTicket();
    }
}
