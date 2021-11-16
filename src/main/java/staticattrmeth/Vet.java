package staticattrmeth;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    List<Dog> dogs = new ArrayList<>();

    private static long code = 1;

    public void add(Dog dog) {
        dogs.add(dog);
        dog.setCode(code++);
    }

    public List<Dog> getDogs() {
        return List.copyOf(dogs);
    }

}
