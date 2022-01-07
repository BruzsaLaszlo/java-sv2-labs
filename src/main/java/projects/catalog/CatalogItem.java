package projects.catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.price = price;
        this.registrationNumber = registrationNumber;
        features.addAll(List.of(feature));
    }

    public int fullLengthAtOneItem() {
        return features.stream()
                .filter(AudioFeatures.class::isInstance)
                .mapToInt(feature -> ((AudioFeatures) feature).getLength())
                .sum();
    }

    public List<String> getContributors() {
        return features.stream()
                .flatMap(feature -> feature.getContributors().stream())
                .toList();
    }

    public List<String> getTitles() {
        return features.stream()
                .map(Feature::getTitle)
                .toList();
    }

    public boolean hasAudioFeature() {
        return features.stream()
                .anyMatch(AudioFeatures.class::isInstance);
    }

    public boolean hasPrintedFeature() {
        return features.stream()
                .anyMatch(PrintedFeatures.class::isInstance);
    }

    public int numberOfPagesAtOneItem() {
        return features.stream()
                .filter(PrintedFeatures.class::isInstance)
                .mapToInt(feature -> ((PrintedFeatures) feature).getNumberOfPages())
                .max()
                .orElse(0);
    }


    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<Feature> getFeatures() {
        return List.copyOf(features);
    }
}
