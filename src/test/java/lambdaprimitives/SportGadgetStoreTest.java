package lambdaprimitives;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SportGadgetStoreTest {

    private List<Product> products;

    @BeforeEach
    void initProducts() {
        products = new ArrayList<>();
        products.add(new Product("Tennis ball", 2.47, 138));
        products.add(new Product("Tennis racket", 29.9, 23));
        products.add(new Product("Running shoes", 57.0, 16));
        products.add(new Product("Fitness banch", 215.0, 7));
        products.add(new Product("Threadmill", 997.0, 4));
        products.add(new Product("Punching bag", 539.9, 3));
        products.add(new Product("Snowboard", 149.0, 12));
        products.add(new Product("Golf ball", 29.99, 64));
        products.add(new Product("Golf club", 127.99, 19));
        products.add(new Product("Mountain bike", 179.0, 5));
    }

    @Test
    void getNumberOfProducts() {
        SportGadgetStore store = new SportGadgetStore(products);

        assertEquals(291, store.getNumberOfProducts());
    }

    @Test
    void getNumberOfProductsForEmptyList() {
        SportGadgetStore store = new SportGadgetStore(Collections.emptyList());

        assertEquals(0, store.getNumberOfProducts());
    }

    @Test
    void getAveragePrice() {
        SportGadgetStore store = new SportGadgetStore(products);

        assertEquals(232.725, store.getAveragePrice());
    }

    @Test
    void getAveragePriceForEmptyList() {
        SportGadgetStore store = new SportGadgetStore(Collections.emptyList());

        assertEquals(0.0, store.getAveragePrice());
    }

    @Test
    void getExpensiveProductStatistics() {
        SportGadgetStore store = new SportGadgetStore(products);
        String expectedString = "Összesen 6 féle termék, amelyekből minimum 3 db, maximum 19 db, összesen 50 db van.";

        assertEquals(expectedString, store.getExpensiveProductStatistics(100.0));
    }

    @Test
    void getExpensiveProductStatisticsForEmptyList() {
        SportGadgetStore store = new SportGadgetStore(Collections.emptyList());

        assertEquals("Nincs ilyen termék.", store.getExpensiveProductStatistics(100.0));
    }

    @Test
    void getExpensiveProductStatisticsWithZeroProduct() {
        SportGadgetStore store = new SportGadgetStore(List.of(new Product("Tennis ball", 2.47, 138)));

        assertEquals("Nincs ilyen termék.", store.getExpensiveProductStatistics(100.0));
    }
}