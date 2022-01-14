package lambdaprimitives;

import java.util.List;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream()
                .mapToInt(Product::piece)
                .sum();
    }

    public double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::price)
                .average()
                .orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        var stat = products.stream()
                .filter(product -> product.price() > minPrice)
                .mapToInt(Product::piece)
                .summaryStatistics();
        if (stat.getCount() == 0) {
            return "Nincs ilyen termék.";
        }
        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",
                stat.getCount(), stat.getMin(), stat.getMax(), stat.getSum());
    }
}
