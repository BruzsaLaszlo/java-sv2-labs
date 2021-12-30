package exceptionmulticatch.converter;

import java.util.Objects;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String codedText) {
        Objects.requireNonNull(codedText, "Binary string is null.");
        var result = new boolean[codedText.length()];

        for (int i= 0; i < result.length; i++) {
            switch (codedText.charAt(i)) {
                case '0' -> result[i] = false;
                case '1' -> result[i] = true;
                default ->throw new IllegalArgumentException("Binary string is not valid.");
            }
        }

        return result;
    }


    public String booleanArrayToBinaryString(boolean[] booleans) {
        if (booleans.length == 0) {
            throw new IllegalArgumentException("Boolean array is empty.");
        }

        var result = new StringBuilder(booleans.length);
        for (boolean b : booleans) {
            result.append(b ? "1" : "0");
        }

        return result.toString();
    }

}
