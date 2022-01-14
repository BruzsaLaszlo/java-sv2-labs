package lambdaprimitives;

import java.util.List;

public class Truck {

    private List<Cargo> thingsToLoad;

    public Truck(List<Cargo> thingsToLoad) {
        this.thingsToLoad = thingsToLoad;
    }

    public double getShortestLength() {
        return thingsToLoad.stream()
                .mapToDouble(Cargo::length)
                .min()
                .orElse(0);
    }

    public int getTotalWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .sum();
    }

    public double getAverageWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("No cargo."));
    }

    public int getMaxWeight() {
        return thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .max()
                .orElse(0);
    }

    public String getWeightStatictics() {
        if (thingsToLoad.isEmpty()) return "No cargo.";
        var stat = thingsToLoad.stream()
                .mapToInt(Cargo::weight)
                .summaryStatistics();
        return String.format("A rakományban található %d tétel, melyeknek összsúlya %d kg," +
                        " közülük a legnehezebb %d kg, a legkönnyebb %d kg. A súlyuk átlagosan %.1f kg.",
                stat.getCount(), stat.getSum(), stat.getMax(), stat.getMin(), stat.getAverage());
    }
}
