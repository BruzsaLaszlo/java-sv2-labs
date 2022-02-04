package kepesitovizsga.potpotvizsga;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private Set<ZooAnimal> animals = new HashSet<>();
    private DataSource dataSource;

    public Zoo() {
    }

    public Zoo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addAnimal(ZooAnimal animal) {
        animals.add(animal);
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals.stream()
                .max(Comparator.comparing(ZooAnimal::getWeight))
                .orElseThrow(() -> new NoSuchElementException("nincsenek állatok vagy a súlyuk elhanyagolható"));
    }

    public int countWeights() {
        return (int) animals.stream()
                .mapToLong(ZooAnimal::getWeight)
                .sum();
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        if (animals.contains(animal)) {
            return animal;
        }
        throw new IllegalArgumentException("There is no such animal in the zoo!");
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return animals.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals.stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .toList();
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        return animals.stream()
                .collect(Collectors.groupingBy(
                        ZooAnimal::getType,
                        Collectors.summingInt(value -> 1)));
    }

    public void loadAnimals() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery("select * from animals")) {
            while (resultSet.next()) {
                String name = resultSet.getString("animal_name");
                int length = resultSet.getInt("length_of_member");
                long weight = resultSet.getLong("weight");
                AnimalType animalType = AnimalType.valueOf(resultSet.getString("animal_type"));
                animals.add(new ZooAnimal(name, length, weight, animalType));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("sqlException", e);
        }
    }

    public void addAnimalToDatabase(ZooAnimal animal) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("insert into animals values (?,?,?,?)")) {
            pstmt.setString(1, animal.getName());
            pstmt.setInt(1, animal.getLength());
            pstmt.setLong(1, animal.getWeight());
            pstmt.setString(1, animal.getType().name());
            pstmt.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException("sqlException", e);
        }
    }
}
