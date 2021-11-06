package conventions;

public class CarMain {


    public static void main(String[] args) {

        Car car = new Car("Skoda", "1.8T", 5, 5);
        car.addModelName("Octavia");

        System.out.println(car.getCarType());
        System.out.println(car.getEngineType());
        System.out.println(car.getDoors());
        System.out.println(car.getPersons());

    }
}
