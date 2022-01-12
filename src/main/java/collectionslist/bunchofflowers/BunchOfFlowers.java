package collectionslist.bunchofflowers;

import java.util.LinkedList;
import java.util.List;

public class BunchOfFlowers {

    private List<String> flowers = new LinkedList<>();

    public void addFlowerInTheMiddle(String flower) {
        if (flowers.size() % 2 == 0) {
            flowers.add(flowers.size() / 2, flower);
        } else {
            flowers.add(flowers.size() / 2, flower);
            flowers.add(flowers.size() / 2 + 1, flower);
        }
    }

    public void addFlower(String flower) {
        flowers.add(flower);
    }

    public List<String> getBunch() {
        return List.copyOf(flowers);
    }

}
