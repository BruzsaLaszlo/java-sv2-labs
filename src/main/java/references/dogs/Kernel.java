package references.dogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kernel {

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

        Dog dog1 = new Dog("Bogi", 8, "fekete");
        Dog dog2 = new Dog("Lüszi", 5, "rozsdabarna");
        Dog dog3 = new Dog("Picúr", 4, "fekete-fehér");
        dogs.addAll(Arrays.asList(dog1, dog2, dog3));
        System.out.println(dogs);

        Dog dog4 = dogs.get(1);
        dog4.setColor("fehér");
        System.out.println(dogs);

        Dog dog5 = new Dog("Morzsi", 7, "barna");
        System.out.println(dog5);
        dog5 = dogs.get(1);
        System.out.println(dog5);

        dogs.add(dog5);
        System.out.println(dogs);

        Dog dog6 = dog4;
        dog4.setColor("zöld");
        System.out.println(dogs);

        List<Dog> anotherList = dogs;
        Dog dog7 = dog4;
        dog7.setColor("hupilila");
        System.out.println(anotherList);
        dog2.setColor("piros és láthatatlan");
        System.out.println(anotherList);

        dog2 = null;
        System.out.println(anotherList);

        Dog dog8 = dogs.get(1);
        dog8 = null;
        System.out.println(anotherList);

        Dog dog9 = dogs.get(1);
        dog9.setColor("neeeemááááá");

        System.out.println(anotherList);

        /** dög */
        Dog dogInfinite = new Dog("Neb@ssz", Integer.MAX_VALUE, "~ black hole ~");

        System.out.println(dogInfinite);

    }

}
