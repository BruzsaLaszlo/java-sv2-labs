package introinheritance.itembasketshoppingbasket;

public class ShoppingBasket {

    private Basket basket;

    public void addItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("invalid item!");
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        if (barcode == null || barcode.isBlank())
            throw new IllegalArgumentException("invalid barcode!");
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        Item max = basket.getItems().get(0);
        for (Item i : basket.getItems()) {
            if (max.getNettoPrice() < i.getNettoPrice()) {
                max = i;
            }
        }
        basket.removeItem(max.getBarcode());
    }

}
