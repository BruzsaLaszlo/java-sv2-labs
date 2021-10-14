package classstructureintegrate;

public class Product {
    private String name;
    private int price;

    public void increasePrice(int i) {
        price += i;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void decreasePrice(int i) {
        price -= i;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
