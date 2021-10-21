package finalmodifier;

public class PiMain {

    public static void main(String[] args) {

        System.out.println("π: " + CircleCalculator.PI);

        final double r = 0.5;
        final double h = 10;

        CircleCalculator circleCalculator = new CircleCalculator();
        System.out.println("Kör kerület: " + circleCalculator.calculatePerimeter(r));
        System.out.println("Kör terület: " + circleCalculator.calculateArea(r));

        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        System.out.println("Henger felszín: " + cylinderCalculator.calculateSurfaceArea(r,h));
        System.out.println("Henger térfogat: " + cylinderCalculator.calculateVolume(r,h));

        CylinderCalculatorBasedOnCircle cylinderCalculatorBasedOnCircle = new CylinderCalculatorBasedOnCircle();
        System.out.println("Henger felszín: " + cylinderCalculatorBasedOnCircle.calculateSurfaceArea(r,h));
        System.out.println("Henger térfogat: " + cylinderCalculatorBasedOnCircle.calculateVolume(r,h));

    }

}
