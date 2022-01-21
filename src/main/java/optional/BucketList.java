package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BucketList {

    private List<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public Optional<Destination> getDestinationWithKeyword(String keyword) {
        return destinations.stream()
                .filter(destination -> destination.getDescription().contains(keyword))
                .findFirst();
    }

    public Optional<Destination> getDestinationNearerThanGiven(int maxKm) {
        return destinations.stream()
                .filter(destination -> destination.getKmFromHome() < maxKm)
                .findFirst();
    }
}
