package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public void addOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public double getTotalIncome() {
        double sum = orders.stream()
                .flatMap(CoffeeOrder::getCoffesStream)
                .mapToDouble(Coffee::getPrice)
                .reduce(Double::sum)
                .orElseThrow();
        return round2(sum);
    }

    public double getTotalIncome(LocalDate date) {
        double sum = orders.stream()
                .filter(order -> order.getTime().getYear() == date.getYear() && order.getTime().getDayOfYear() == date.getDayOfYear())
                .flatMap(CoffeeOrder::getCoffesStream)
                .mapToDouble(Coffee::getPrice)
                .reduce(Double::sum)
                .orElseThrow();
        return round2(sum);
    }

    public long getNumberOfCoffee(CoffeType type) {
        return orders.stream()
                .flatMap(CoffeeOrder::getCoffesStream)
                .filter(coffee -> coffee.getType() == type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(order -> order.getTime().isAfter(from))
                .toList();
    }

    public List<Coffee> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(order -> order.getTime().getYear() == date.getYear() && order.getTime().getDayOfYear() == date.getDayOfYear())
                .flatMap(CoffeeOrder::getCoffesStream)
                .collect(Collectors.toSet()).stream()
                .limit(5)
                .toList();
    }

    private double round2(double sum) {
        return Math.round(sum * 100d) / 100d;
    }
}
