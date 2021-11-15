package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private final List<Trooper> troopers = new ArrayList<>();

    public void addTrooper(Trooper trooper) {
        if (trooper == null)
            throw new IllegalStateException("parameters is null");
        troopers.add(trooper);
    }

    public List<Trooper> getTroopers() {
        return new ArrayList<>(troopers);
    }

    public void moveTrooperByName(String name, Position target) {
        if (name == null || name.isBlank() || target == null)
            throw new IllegalStateException("parameters is/are null/empty");

        moveTrooper(findTrooperByName(name), target);
    }

    public void moveClosestTrooper(Position target) {
        if (target == null)
            throw new IllegalStateException("parameters is null");

        findClosestTrooper(target)
                .chagePosition(target);
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper closest = troopers.get(0);
        double distance = closest.disntaceFrom(target);
        for (Trooper t : troopers) {
            if (t.disntaceFrom(target) < distance) {
                closest = t;
                distance = closest.disntaceFrom(target);
            }
        }
        return closest;
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper t : troopers) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        throw new IllegalStateException("No trooper is name : " + name);
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.chagePosition(target);
    }
}
