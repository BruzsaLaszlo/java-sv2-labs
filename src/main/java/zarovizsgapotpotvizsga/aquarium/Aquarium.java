package zarovizsgapotpotvizsga.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fish = new ArrayList<>();

    public void addFish(Fish fish) {
        this.fish.add(fish);
    }

    public void feed() {
        fish.forEach(Fish::feed);
    }

    public void removeFish() {
        fish.removeIf(f -> f.getWeight() >= 11);
    }

    public List<String> getStatus() {
        return fish.stream()
                .map(Fish::status)
                .toList();
    }
}
