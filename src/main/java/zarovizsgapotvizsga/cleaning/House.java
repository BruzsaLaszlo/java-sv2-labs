package zarovizsgapotvizsga.cleaning;

public class House implements Cleanable {

    private static final int PRICE_PER_SQUAREMETER = 80;

    private String address;
    private int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return area * PRICE_PER_SQUAREMETER;
    }

    @Override
    public String getAddress() {
        return address;
    }

}
