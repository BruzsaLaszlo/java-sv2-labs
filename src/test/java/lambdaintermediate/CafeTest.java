package lambdaintermediate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CafeTest {

    Cafe cafe = new Cafe(List.of(
            new CoffeeOrder(List.of(
                    new Coffee(CoffeType.AMERICANO, 1.34),
                    new Coffee(CoffeType.CAPPUCCINO, 1.54),
                    new Coffee(CoffeType.ESPRESSO, 1.65),
                    new Coffee(CoffeType.LATTE, 1.24),
                    new Coffee(CoffeType.MOCHA, 2.44)),
                    LocalDateTime.of(2022, 1, 4, 10, 10)),
            new CoffeeOrder(List.of(
                    new Coffee(CoffeType.CAPPUCCINO, 1.54),
                    new Coffee(CoffeType.ESPRESSO, 1.65),
                    new Coffee(CoffeType.MOCHA, 2.44)),
                    LocalDateTime.of(2022, 1, 5, 10, 10)),
            new CoffeeOrder(List.of(
                    new Coffee(CoffeType.RISTRETTO, 1.65),
                    new Coffee(CoffeType.LATTE, 1.24),
                    new Coffee(CoffeType.MOCHA, 2.44)),
                    LocalDateTime.of(2022, 1, 6, 10, 10)),
            new CoffeeOrder(List.of(
                    new Coffee(CoffeType.MACHIATTO, 1.34),
                    new Coffee(CoffeType.MOCHA, 2.44)),
                    LocalDateTime.of(2022, 1, 7, 10, 10))

    ));

    @Test
    void getTotalIncome() {
        assertEquals(22.95, cafe.getTotalIncome());
    }

    @Test
    void getTotalIncomeByDate() {
        assertEquals(3.78, cafe.getTotalIncome(LocalDate.of(2022, 1, 7)));
    }

    @Test
    void getNumberOfCoffee() {
        assertEquals(2, cafe.getNumberOfCoffee(CoffeType.CAPPUCCINO));
    }

    @Test
    void getOrdersAfter() {
        assertEquals(2, cafe.getOrdersAfter(LocalDateTime.of(2022, 1, 6, 0, 0)).size());
    }

    @Test
    void getFirstFiveOrder() {
        assertEquals(5, cafe.getFirstFiveOrder(LocalDate.of(2022, 1, 4)).size());
        assertEquals(3, cafe.getFirstFiveOrder(LocalDate.of(2022, 1, 6)).size());
    }
}