package conversions;

public class TooBigNumber {

    public long getRightResult(int number) {
        return (long) Integer.MAX_VALUE + number;
    }


    public static void main(String[] args) {

        TooBigNumber tooBigNumber = new TooBigNumber();

        System.out.println(tooBigNumber.getRightResult(0));
        System.out.println(tooBigNumber.getRightResult(1));
        System.out.println(tooBigNumber.getRightResult(128));

    }

}
