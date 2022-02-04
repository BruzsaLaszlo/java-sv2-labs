package kepesitovizsga.potpotvizsga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ElephantTest {

    @Test
    void testCreate() {
        ZooAnimal elephant = new Elephant("Kumba", 2, 3456);

        Assertions.assertEquals("Kumba", elephant.getName());
        Assertions.assertEquals(2, elephant.getLength());
        Assertions.assertEquals(3456L, elephant.getWeight());
        Assertions.assertEquals(AnimalType.ELEPHANT, elephant.getType());
    }
}
