package kepesitovizsga.potpotvizsga;

import kepesitovizsgapotpotvizsga.AnimalType;
import kepesitovizsgapotpotvizsga.Giraffe;
import kepesitovizsgapotpotvizsga.ZooAnimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GiraffeTest {

    @Test
    void testCreate() {
        ZooAnimal giraffe = new Giraffe("Momba", 3);

        Assertions.assertEquals("Momba", giraffe.getName());
        Assertions.assertEquals(3, giraffe.getLength());
        Assertions.assertEquals(0L, giraffe.getWeight());
        Assertions.assertEquals(AnimalType.GIRAFFE, giraffe.getType());
    }
}
