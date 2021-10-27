package operators;

public class Operators {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public String getResultOfDivision(int number, int divisor) {
        return String.format("%d / %d = %d, maradék %d", number, divisor, number / divisor, number % divisor);
    }

    public String isNull(String s) {
        return s == null ? "null értekű" : "nem null értékű";
    }

    public boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

}
