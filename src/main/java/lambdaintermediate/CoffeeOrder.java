package lambdaintermediate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrder {

    private List<Coffee> coffees;
    private LocalDateTime time;

    public CoffeeOrder(List<Coffee> coffees, LocalDateTime time) {
        this.coffees = coffees;
        this.time = time;
    }

    public List<Coffee> getCoffes() {
        return coffees;
    }

    public Stream<Coffee> getCoffesStream() {
        return coffees.stream();
    }

    public LocalDateTime getTime() {
        return time;
    }
}
