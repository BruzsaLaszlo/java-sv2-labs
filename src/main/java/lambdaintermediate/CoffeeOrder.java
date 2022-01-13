package lambdaintermediate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrder {

    private List<Coffee> coffeeList;
    private LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffeeList, LocalDateTime dateTime) {
        this.coffeeList = coffeeList;
        this.dateTime = dateTime;
    }

    public List<Coffee> getCoffeeList() {
        return Collections.unmodifiableList(coffeeList);
    }

    public Stream<Coffee> getCoffesStream() {
        return coffeeList.stream();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
