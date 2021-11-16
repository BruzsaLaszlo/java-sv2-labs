package methodparam.sum;

public class Sums {

    private double negativeSum;

    private double positiveSum;

    public double getNegativeSum() {
        return negativeSum;
    }

    public void addNegative(double negativeNumber) {
        negativeSum += negativeNumber;
    }

    public double getPositiveSum() {
        return positiveSum;
    }

    public void addPositive(double positiveNumber) {
        positiveSum += positiveNumber;
    }
}
