package collectionsiterator;

import java.util.List;

public class ChristmasShopping {

    private List<ChristmasPresent> presents;

    public ChristmasShopping(List<ChristmasPresent> presents) {
        this.presents = presents;
    }

    public void addNewPresent(ChristmasPresent present) {
        presents.add(present);
    }

    public void removeTooExpensivePresent(int maxPrice) {
        var iterator = presents.listIterator();
        while (iterator.hasNext()) {
            if (maxPrice < iterator.next().price()) {
                iterator.remove();
            }
        }
    }
}
