package methodstructure.bmi;

public class BodyMass {

    private int weigth;
    private double height;

    public double getBodyMassIndex() {
        return weigth / (height * height);
    }

    public BmiCategory getBody() {
        double bodyMassIndex = getBodyMassIndex();
        if (bodyMassIndex < 18.5) {
            return BmiCategory.UNDERWEIGHT;
        } else if (bodyMassIndex > 25) {
            return BmiCategory.OVERWEIGHT;
        } else {
            return BmiCategory.NORMAL;
        }
    }

    public boolean isThinnerThan(BodyMass other) {
        return this.getBodyMassIndex() < other.getBodyMassIndex();
    }

    public int getWeigth() {
        return weigth;
    }

    public double getHeight() {
        return height;
    }
}
