package collectionscomp;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Building implements Comparable<Building> {

    private String address;
    private double area;
    private int level;

    public Building(String address, double area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    public static void main(String[] args) {
        Set<Building> buildings = new TreeSet<>(Set.of(
                new Building("Kossuth", 3423.23, 5),
                new Building("Bajcsy", 233.43, 6),
                new Building("Ady", 234332d, 54)
        ));
        System.out.println(buildings);
    }

    @Override
    public int compareTo(Building o) {
        return level - o.level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return level == building.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", level=" + level +
                '}';
    }
}
