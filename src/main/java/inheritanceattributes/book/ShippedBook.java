package inheritanceattributes.book;

public class ShippedBook extends Book {

    private final int shippingCost;

    public ShippedBook(String title, int price, int shippingCost) {
        super(title, price);
        this.shippingCost = shippingCost;
    }

    public int orderSize(int pieces) {
        return purchase(pieces) + shippingCost;
    }

    @Override
    public String toString() {
        return getTitle() + ": " +
                price + " Ft" +
                ", postaköltség: " + shippingCost + " Ft";
    }
}
