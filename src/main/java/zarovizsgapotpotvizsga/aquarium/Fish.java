package zarovizsgapotpotvizsga.aquarium;

public abstract class Fish {

    private String name;
    private int weight;
    private String color;

    protected Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public abstract boolean hasMemoryLoss();

    public abstract void feed();

    public String status() {
        return String.format("%s, weight: %d, color: %s, short term memory loss: %b",
                name, weight, color, hasMemoryLoss());
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
