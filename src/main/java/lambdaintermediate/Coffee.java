package lambdaintermediate;

public class Coffee {

    private CoffeType type;
    private double price;

    public Coffee(CoffeType type, double price) {
        this.type = type;
        this.price = price;
    }

    public CoffeType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
