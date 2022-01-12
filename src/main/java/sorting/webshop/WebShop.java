package sorting.webshop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebShop {

    private List<Product> products = new ArrayList<>();

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Product> getProductsOrderByName() {
        var copy = new ArrayList<>(products);
        copy.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.name().compareTo(o2.name());
            }
        });
        return copy;
    }

    public List<Product> getProductsOrderByPrice() {
        var copy = new ArrayList<>(products);
        copy.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.price(), o2.price());
            }
        });
        return copy;
    }

    public List<Product> getProductsOrderByDate() {
        var copy = new ArrayList<>(products);
        copy.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.from().compareTo(o2.from());
            }
        });
        return copy;
    }

}
