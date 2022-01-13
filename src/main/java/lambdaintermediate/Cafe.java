package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public void addOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public BigDecimal getTotalIncome() {
        return orders.stream()
                .flatMap(CoffeeOrder::getCoffesStream)
                .map(Coffee::getPrice)
                .reduce(BigDecimal::add)
                .orElseThrow()
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(order -> order.getDateTime().getYear() == date.getYear() && order.getDateTime().getDayOfYear() == date.getDayOfYear())
                .flatMap(CoffeeOrder::getCoffesStream)
                .map(Coffee::getPrice)
                .reduce(BigDecimal::add)
                .orElseThrow()
                .setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(CoffeeOrder::getCoffesStream)
                .filter(coffee -> coffee.getType() == type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(order -> order.getDateTime().isAfter(from))
                .toList();
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(order -> order.getDateTime().getYear() == date.getYear() && order.getDateTime().getDayOfYear() == date.getDayOfYear())
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .toList();
    }

}
