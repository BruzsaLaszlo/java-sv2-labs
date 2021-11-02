package introexceptiontrace.aquarium;

public class AquariumMain {

    public static void main(String[] args) {

        Aquarium aquarium = new Aquarium();
        Fish harcsa = new Fish("Harcsa", "szürke");
        Fish ponty = new Fish("Ponty", "arany");
        Fish keszeg = new Fish("Keszeg", "ezüst");
        aquarium.addFish(harcsa);
        aquarium.addFish(keszeg);
        aquarium.addFish(ponty);
        System.out.println(aquarium.getNumberOfFish());

        // List<Fish> ornamentalFish nem lett inicializalva

    }

}
