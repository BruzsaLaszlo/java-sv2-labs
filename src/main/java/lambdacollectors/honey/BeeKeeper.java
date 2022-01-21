package lambdacollectors.honey;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class BeeKeeper {

    private List<Honey> honeys;

    public BeeKeeper(List<Honey> honeys) {
        this.honeys = honeys;
    }


    public void addHoney(Honey honey) {
        honeys.add(honey);
    }


    public int getTotalValueOfGivenGlasses(GlassSize size) {
        return honeys.stream()
                .collect(filtering(
                        honey -> honey.getGlassSize() == size,
                        summingDouble(honey -> honey.getGlassSize().getKg() * honey.getHoneyType().getPrice())))
                .intValue();
    }

    public Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type) {
        return honeys.stream()
                .collect(filtering(
                        honey -> honey.getHoneyType() == type,
                        groupingBy(
                                Honey::getGlassSize,
                                counting()
                        )));
    }

    public Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size) {
        return honeys.stream()
                .collect(partitioningBy(
                        honey -> honey.getHoneyType() == type && honey.getGlassSize() == size,
                        toList()
                ));
    }
}
