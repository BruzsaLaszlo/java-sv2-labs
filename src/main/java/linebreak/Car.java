package linebreak;

public class Car {

    public String getBrandAndTypeInSeparateLines(String brand, String type) {
        return brand + "\n" + type;
    }

    public static void main(String[] args) {

        Car car = new Car();

        String lines = car.getBrandAndTypeInSeparateLines("Skoda", "Octavia");

        System.out.println(lines);

    }

}
