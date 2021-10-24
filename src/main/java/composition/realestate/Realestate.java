package composition.realestate;

public class Realestate {

    private String title;
    private double price;
    private Details details;

    public Realestate(String title, double price, Details details) {
        this.title = title;
        this.price = price;
        this.details = details;
    }

    @Override
    public String toString() {
        return title + '\'' + "\n" +
                "price = " + (int)price + "\n" +
                details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
