package lambdacomparator.cloud;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsFirst;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorages) {
        return cloudStorages.stream()
                .min(comparing(CloudStorage::getProvider, String::compareToIgnoreCase))
                .orElseThrow(IllegalArgumentException::new);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorages) {
        return cloudStorages.stream()
                .min(comparing(CloudStorage::getPeriod, nullsFirst(PayPeriod::compare))
                        .thenComparingDouble(CloudStorage::getPrice))
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorages) {
        return cloudStorages.stream()
                .sorted()
                .limit(3)
                .sorted(comparing(CloudStorage::getPrice).reversed())
                .toList();
    }
}
