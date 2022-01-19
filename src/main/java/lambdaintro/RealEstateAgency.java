package lambdaintro;

import java.util.List;
import java.util.function.Predicate;

public class RealEstateAgency {

    private List<Flat> flats;

    public RealEstateAgency(List<Flat> flats) {
        this.flats = flats;
    }

    private Flat findFirst(Predicate<Flat> condition) {
        return flats.stream()
                .filter(condition)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such flat."));
    }

    public Flat findFirstCheaperFlat(int maxPrice) {
        return findFirst(flat -> flat.getPrice() < maxPrice);
    }

    public Flat findFirstGreaterFlat(double minArea) {
        return findFirst(flat -> flat.getArea() > minArea);
    }

    public Flat findFirstFlatInSameTown(String town) {
        return findFirst(flat -> flat.getAddress().startsWith(town));
    }
}
