package introinheritance.coffee;

public class Coffee {

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public Coffee setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Coffee setPrice(int price) {
        this.price = price;
        return this;
    }


    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
