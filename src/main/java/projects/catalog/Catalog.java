package projects.catalog;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Catalog {

    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalog) {
        catalogItems.add(catalog);
    }

    public double averagePageNumberOver(int page) {
        if (page < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        IntSummaryStatistics stat = catalogItems.stream()
                .flatMap(catalogItem -> catalogItem.getFeatures().stream())
                .filter(PrintedFeatures.class::isInstance)
                .mapToInt(feature -> ((PrintedFeatures) feature).getNumberOfPages())
                .filter(value -> value > page)
                .summaryStatistics();

        if (stat.getCount() == 0) {
            throw new IllegalArgumentException("No page");
        }
        return stat.getAverage();
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        CatalogItem found = catalogItems.stream()
                .filter(catalogItem -> catalogItem.getRegistrationNumber().equals(registrationNumber))
                .findFirst()
                .orElseThrow();
        catalogItems.remove(found);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria criteria) {
        return catalogItems.stream()
                .filter(catalogItem ->
                        catalogItem.getContributors().stream().anyMatch(s -> s.equals(criteria.getContributor()))
                                || catalogItem.getTitles().stream().anyMatch(s -> s.equals(criteria.getTitle())))
                .toList();
    }

    public int getAllPageNumber() {
        return catalogItems.stream()
                .flatMap(catalogItem -> catalogItem.getFeatures().stream())
                .filter(PrintedFeatures.class::isInstance)
                .mapToInt(feature -> ((PrintedFeatures) feature).getNumberOfPages())
                .sum();
    }

    public List<CatalogItem> getAudioLibraryItems() {
        return catalogItems.stream()
                .filter(CatalogItem::hasAudioFeature)
                .toList();
    }

    public int getFullLength() {
        return catalogItems.stream()
                .flatMap(catalogItem -> catalogItem.getFeatures().stream())
                .filter(AudioFeatures.class::isInstance)
                .mapToInt(feature -> ((AudioFeatures) feature).getLength())
                .sum();
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        return catalogItems.stream()
                .filter(CatalogItem::hasPrintedFeature)
                .toList();
    }
}
