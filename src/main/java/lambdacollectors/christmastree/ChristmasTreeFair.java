package lambdacollectors.christmastree;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class ChristmasTreeFair {

    private List<ChristmasTree> christmasTrees;

    public ChristmasTreeFair(List<ChristmasTree> christmasTrees) {
        this.christmasTrees = christmasTrees;
    }


    public Map<PineTreeType, Long> getCountByType() {
        return christmasTrees.stream()
                .collect(groupingBy(
                        ChristmasTree::getType,
                        counting()
                ));
    }


    public double getMaxHeightByType(PineTreeType spruce) {
        return christmasTrees.stream()
                .collect(groupingBy(
                        ChristmasTree::getType,
                        maxBy(comparing(ChristmasTree::getHeight))))
                .getOrDefault(spruce, Optional.empty())
                .map(ChristmasTree::getHeight)
                .orElse(0.0);
    }


    @SuppressWarnings("SimplifyStreamApiCallChains")
    public double getAveragePrice() {
        return christmasTrees.stream()
                .collect(mapping(
                        ChristmasTree::getType,
                        averagingDouble(PineTreeType::getPricePerMeter)));
    }
}
