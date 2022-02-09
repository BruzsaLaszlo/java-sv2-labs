package zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        setHappiness(getHappiness() + 2);
    }

    @Override
    public void play(int hours) {
        setHappiness(getHappiness() + hours * 2);
    }
}
