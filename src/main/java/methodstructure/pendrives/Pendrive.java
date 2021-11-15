package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;


    public void risePrice(int percent) {
        price += price * (percent / 100d);
    }


    public int comparePricePerCapacity(Pendrive other) {
        double ppc = (double) price / capacity;
        double ppcOther = (double) other.price / other.capacity;

        return Double.compare(ppc, ppcOther);
    }

    public boolean isCheaperThan(Pendrive other) {
        return price < other.price;
    }


    @Override
    public String toString() {
        return "Pendrives{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}
