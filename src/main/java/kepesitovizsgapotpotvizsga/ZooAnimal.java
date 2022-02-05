package kepesitovizsgapotpotvizsga;

import java.util.Objects;

public class ZooAnimal {

    private String name;
    private int length;
    private long weight;
    private AnimalType type;

    protected ZooAnimal(String name, int length, long weight, AnimalType type) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooAnimal zooAnimal = (ZooAnimal) o;
        return Objects.equals(name, zooAnimal.name) && Objects.equals(length, zooAnimal.length) && Objects.equals(weight, zooAnimal.weight) && type == zooAnimal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, weight, type);
    }
}
