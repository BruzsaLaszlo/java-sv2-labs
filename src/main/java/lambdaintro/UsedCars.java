package lambdaintro;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class UsedCars {

    private List<Car> cars;

    public UsedCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> listCarsByPrice() {
        return cars.stream()
                .sorted(comparingInt(Car::getPrice))
                .toList();
    }

    public List<Car> listCarsByLengthDesc() {
        return cars.stream()
                .sorted(comparing(Car::getLength).reversed())
                .toList();
    }

    public List<Car> listCarsOneBrandByType(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .sorted(comparing(Car::getType))
                .toList();
    }
}
