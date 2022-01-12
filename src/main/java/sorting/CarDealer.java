package sorting;

import java.util.ArrayList;
import java.util.List;

public class CarDealer {

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCarsOrderedByYearOfConstruction() {
        cars.sort(new CarConstructionComparator());
        return cars;
    }

    public List<Car> getCarsOrderedByPrice() {
        cars.sort(new CarPriceComparator());
        return cars;
    }
}
