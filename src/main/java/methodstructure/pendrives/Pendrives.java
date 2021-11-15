package methodstructure.pendrives;

import java.util.List;

public class Pendrives {


    public Pendrive getCheapest(List<Pendrive> pendrives) {

        Pendrive cheapest = pendrives.get(0);
        for (int i = 1; i < pendrives.size() - 1; i++) {
            if (pendrives.get(i).isCheaperThan(cheapest)) {
                cheapest = pendrives.get(i);
            }
        }
        return cheapest;

    }


    public Pendrive getBest(List<Pendrive> pendrives) {

        Pendrive best = pendrives.get(0);
        for (int i = 1; i < pendrives.size(); i++) {
            if (best.comparePricePerCapacity(pendrives.get(i)) > 0) {
                best = pendrives.get(0);
            }
        }

        return best;
    }


    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {

        for (Pendrive p : pendrives) {
            if (p.getCapacity() == capacity) {
                p.risePrice(percent);
            }
        }
    }

}
