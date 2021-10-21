package finalmodifier;

public class CylinderCalculator {

    public double calculateVolume(double r, double h) {
        return CircleCalculator.PI * r * r * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        return 2 * CircleCalculator.PI * r * h + 2 * CircleCalculator.PI * r * r;
    }

}
