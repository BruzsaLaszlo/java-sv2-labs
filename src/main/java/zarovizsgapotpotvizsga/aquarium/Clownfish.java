package zarovizsgapotpotvizsga.aquarium;

public class Clownfish extends Fish {

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        setWeight(getWeight() + 1);
    }

    @Override
    public boolean hasMemoryLoss() {
        return false;
    }
}
