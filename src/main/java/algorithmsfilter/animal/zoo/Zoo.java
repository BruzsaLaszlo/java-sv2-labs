package algorithmsfilter.animal.zoo;

import algorithmsfilter.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimalsWithNumberOfLegsGiven(int numberOfLegs) {
        List<Animal> list = new ArrayList<>();
        for (Animal animal : animals)
            if (animal.getNumberOfLegs() == numberOfLegs)
                list.add(animal);

        return list;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
