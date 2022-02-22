package zarovizsgapotvizsga.cleaning;

public class Office implements Cleanable {

    private static final int PRICE_PER_SQUAREMETER = 100;

    private String address;
    private int area;
    private int level;

    public Office(String address, int area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    @Override
    public int clean() {
        return area * level * PRICE_PER_SQUAREMETER;
    }

    @Override
    public String getAddress() {
        return address;
    }

}

