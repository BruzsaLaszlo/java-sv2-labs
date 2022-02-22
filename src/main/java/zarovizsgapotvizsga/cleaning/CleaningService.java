package zarovizsgapotvizsga.cleaning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();


    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return Collections.unmodifiableList(cleanables);
    }

    public int cleanAll() {
        int sum = cleanables.stream()
                .mapToInt(Cleanable::clean)
                .sum();
        cleanables.clear();
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = cleanables.stream()
                .filter(Office.class::isInstance)
                .mapToInt(Cleanable::clean)
                .sum();
        cleanables.removeIf(Office.class::isInstance);
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        return cleanables.stream()
                .filter(cleanable -> cleanable.getAddress().contains(address))
                .toList();
    }

    public String getAddresses() {
        return cleanables.stream()
                .map(Cleanable::getAddress)
                .collect(Collectors.joining(", "));
    }
}
