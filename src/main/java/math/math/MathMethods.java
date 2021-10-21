package math.math;

public class MathMethods {

    public static void main(String[] args) {

        String mindenEgybe =
                        Math.min(1, 100) + "\n" +
                        Math.max(0, 100) + "\n" +
                        Math.PI + "\n" +
                        Math.round(Math.PI) + "\n" +
                        Math.round(1.5) + "\n" +
                        Math.abs(-12.345) + "\n" +
                        Math.negateExact(1) + "\n" +
                        Math.addExact(2, 2) + "\n" +
                        Math.subtractExact(2, 2) + "\n" +
                        Math.multiplyExact(2, 2) + "\n" +
                        Math.pow(1.1, 1.1) + "\n" +
                        Math.nextUp(1d) + "\n" +
                        Math.nextDown(1d) + "\n" +
                        Math.random() + "\n";

        System.out.println(mindenEgybe);

    }
}
