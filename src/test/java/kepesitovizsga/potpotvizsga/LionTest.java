package kepesitovizsga.potpotvizsga;

import kepesitovizsgapotpotvizsga.AnimalType;
import kepesitovizsgapotpotvizsga.Lion;
import kepesitovizsgapotpotvizsga.ZooAnimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LionTest {

    @Test
    void testCreate() {
        ZooAnimal lion = new Lion("Simba");

        Assertions.assertEquals("Simba", lion.getName());
        Assertions.assertEquals(0, lion.getLength());
        Assertions.assertEquals(0L, lion.getWeight());
        Assertions.assertEquals(AnimalType.LION, lion.getType());
    }
}