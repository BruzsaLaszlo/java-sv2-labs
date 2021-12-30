package collectionsequalshash.registrationnumber;

import java.util.List;

public class WebShop {

    private List<Product> products;

    public static void main(String[] args) {
        WebShop webShop = new WebShop(List.of(
                new Product("intel-4670K", "120"),
                new Product("intel-4670", "121"),
                new Product("intel-4670", "121"),
                new Product("intel-4770K", "122")
        ));
        System.out.println(webShop.findHowMany(new Product("cpu", "121")));
    }

    public WebShop(List<Product> products) {
        this.products = products;
    }

    public int findHowMany(Product product) {
        int count = 0;
        for (Product p : products) {
            if (p.equals(product)) {
                count++;
            }
        }
        return count;
    }
}
