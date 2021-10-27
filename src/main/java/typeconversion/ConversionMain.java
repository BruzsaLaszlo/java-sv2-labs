package typeconversion;

import java.util.Arrays;

public class ConversionMain {

    public static void main(String[] args) {

        Conversion conversion = new Conversion();

        System.out.println(conversion.convertDoubleToDouble(123.456));
        System.out.println(Arrays.toString(conversion.convertIntArrayToByteArray(new int[]{5, -14, 6, 2, 125, 354, 9738, 3})));
        System.out.println(conversion.getFirstDecimal(123.456));

    }

}
