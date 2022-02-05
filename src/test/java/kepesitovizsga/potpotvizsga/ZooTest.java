package kepesitovizsga.potpotvizsga;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ZooTest {

    private Zoo zoo;
    private Zoo zooDatabase;

    @BeforeEach
    void setUp() {
        zoo = new Zoo();
        zoo.addAnimal(new Elephant("Ambassador", 2, 6500));
        zoo.addAnimal(new Lion("Aaliyah"));
        zoo.addAnimal(new Lion("Savannah"));
        zoo.addAnimal(new Giraffe("Unika", 2));
        zoo.addAnimal(new Giraffe("Kamili", 3));
        zoo.addAnimal(new Lion("Simba"));
        zoo.addAnimal(new Elephant("Diana", 2, 4200));
        zoo.addAnimal(new Lion("Betsabé"));
        zoo.addAnimal(new Giraffe("Zara", 2));
        zoo.addAnimal(new Lion("Leonidas"));
        zoo.addAnimal(new Giraffe("Zazi", 3));
        zoo.addAnimal(new Elephant("Serafina", 1, 3100));
        zoo.addAnimal(new Lion("Kopa"));

        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

            Flyway fw = Flyway.configure()
                    .dataSource(dataSource)
                    .locations("filesystem:src/test/resources/kepesitovizsga.potpotvizsga")
                    .load();
            fw.clean();
            fw.migrate();

            zooDatabase = new Zoo(dataSource);
            zooDatabase.loadAnimals();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not reach database.", sqle);
        }
    }

    @Test
    void testAddAnimalThroughGetter() {
        assertEquals(13, zoo.getAnimals().size());

        zoo.getAnimals().add(new Lion("Pumba"));

        assertEquals(13, zoo.getAnimals().size());
    }

    @Test
    void testGetHeaviestAnimalInTheZoo() {
        ZooAnimal elephant = new Elephant("Ambassador", 2, 6500);

        assertEquals(elephant, zoo.getHeaviestAnimalInTheZoo());
    }

    @Test
    void testCountWeights() {
        assertEquals(13800, zoo.countWeights());
    }

    @Test
    void testFindExactAnimal() {
        ZooAnimal lion = new Lion("Aaliyah");

        assertEquals(lion, zoo.findExactAnimal(new Lion("Aaliyah")));
    }

    @Test
    void testFindExactAnimalNotExisting() {
        ZooAnimal elephant = new Elephant("Ola", 2, 5679);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> zoo.findExactAnimal(elephant));
        assertEquals("There is no such animal in the zoo!", ex.getMessage());
    }

    @Test
    void testFindExactAnimalByName() {
        ZooAnimal elephant = new Elephant("Serafina", 1, 3100);

        assertEquals(elephant, zoo.findExactAnimalByName("Serafina"));
    }

    @Test
    void testFindExactAnimalByNameNotExisting() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> zoo.findExactAnimalByName("xyz"));
        assertEquals("There is no such animal in the zoo!", ex.getMessage());
    }

    @Test
    void testGetNumberOfAnimals() {
        assertEquals(13, zoo.getNumberOfAnimals());
    }

    @Test
    void testGetAnimalsOrderedByName() {
        List<ZooAnimal> zooAnimals = zoo.getAnimalsOrderedByName();

        assertEquals("Aaliyah", zooAnimals.get(0).getName());
        assertEquals("Diana", zooAnimals.get(3).getName());
        assertEquals("Simba", zooAnimals.get(9).getName());
    }

    @Test
    void testGetAnimalStatistics() {
        Map<AnimalType, Integer> statistics = zoo.getAnimalStatistics();

        assertEquals(6, statistics.get(AnimalType.LION));
        assertEquals(4, statistics.get(AnimalType.GIRAFFE));
        assertEquals(3, statistics.get(AnimalType.ELEPHANT));
    }

    @Test
    void testAddAnimal() {
        ZooAnimal giraffe = new Giraffe("Balboa", 3);

        assertFalse(zooDatabase.getAnimals().contains(giraffe));
        assertEquals(13, zooDatabase.getAnimals().size());

        zooDatabase.addAnimal(giraffe);
        zooDatabase.loadAnimals();

        assertTrue(zooDatabase.getAnimals().contains(giraffe));
        assertEquals(14, zooDatabase.getAnimals().size());
    }

    @Test
    void testAddAnimalTwice() {
        ZooAnimal giraffe = new Giraffe("Balboa", 3);

        assertFalse(zooDatabase.getAnimals().contains(giraffe));
        assertEquals(13, zooDatabase.getAnimals().size());

        zooDatabase.addAnimal(giraffe);
        zooDatabase.loadAnimals();

        assertTrue(zooDatabase.getAnimals().contains(giraffe));
        assertEquals(14, zooDatabase.getAnimals().size());

        zooDatabase.addAnimal(giraffe);
        zooDatabase.loadAnimals();

        assertTrue(zooDatabase.getAnimals().contains(giraffe));
        assertEquals(14, zooDatabase.getAnimals().size());
    }
}
