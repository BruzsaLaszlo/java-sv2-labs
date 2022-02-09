package zarovizsga.kennel;

public abstract class Dog {

    private String name;
    private int happiness;

    protected Dog(String name) {
        this.name = name;
    }

    public abstract void feed();

    public abstract void play(int hours);

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

}
