package polymorphism.river;

import java.util.List;

public class Danube extends River {

    private List<String> capitals;

    public Danube(String name, int length, List<String> capitals) {
        super(name, length);
        this.capitals = capitals;
    }

    public List<String> getCapitals() {
        return List.copyOf(capitals);
    }

    public static void main(String[] args) {

        Danube duna = new Danube(
                "Duna",
                2850,
                List.of("Vienna", "Bratislava", "Budapest", "Belgrade"));

        Water water = duna;
        River river = duna;

        System.out.println(river.getName() + " " + river.getLength());
        System.out.println(duna.getName() + " " + duna.getLength() + " " + duna.getCapitals());
    }

}
