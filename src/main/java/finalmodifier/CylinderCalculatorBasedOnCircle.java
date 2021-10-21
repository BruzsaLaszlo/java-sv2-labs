package finalmodifier;

public class CylinderCalculatorBasedOnCircle {

    CircleCalculator circleCalculator = new CircleCalculator();

    public double calculateVolume(double r, double h) {
        return circleCalculator.calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return circleCalculator.calculatePerimeter(r) * h + 2 * circleCalculator.calculateArea(r);
    }

}
