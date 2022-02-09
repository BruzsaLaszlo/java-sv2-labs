package zarovizsga.kennel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        dogs.forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        return dogs.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("can not found " + name));
    }

    public void playWith(String name, int hours) {
        dogs.stream()
                .filter(dog -> dog.getName().equals(name))
                .forEach(dog -> dog.play(hours));
    }

    public List<String> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                .filter(dog -> dog.getHappiness() > minHappiness)
                .map(Dog::getName)
                .toList();
    }

    public List<Dog> getDogs() {
        return Collections.unmodifiableList(dogs);
    }
}
