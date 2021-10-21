package finalmodifier;

public class TaxCalculator {

    public static final double AFA = 0.27;

    public double tax(double price) {
        return price * AFA;
    }

    public double priceWithTax(double price) {
        return price + tax(price);
    }

}
