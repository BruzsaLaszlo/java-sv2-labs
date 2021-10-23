package attributes.bill;

public class BillItem {

    private String product;
    private int price;
    private int quantity;
    private double vatPercent;

    public static void main(String[] args) {

        BillItem billItem = new BillItem("tojás", 37, 10, 27);

        System.out.println(billItem.calculatePrice());

    }

    public BillItem(String product, int price, int quantity, double vatPercent) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.vatPercent = vatPercent;
    }

    public int calculatePrice() {
        return (int) (price * quantity * ( 1 + vatPercent / 100));
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getVatPercent() {
        return vatPercent;
    }
}
