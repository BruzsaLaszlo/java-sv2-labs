package lambdacomparator.cloud;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorages) {
        cloudStorages.sort(comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
        return cloudStorages.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorages) {
        cloudStorages = new ArrayList<>(cloudStorages);
        cloudStorages.sort(comparingDouble(CloudStorage::getPrice));
        return cloudStorages.get(0);
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorages) {
        return cloudStorages.stream()
                .sorted()
                .limit(3)
                .sorted(comparing(CloudStorage::getPrice).reversed())
                .toList();
    }
}
