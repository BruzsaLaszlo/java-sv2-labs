package typeconversion;

public class Conversion {

    public double convertDoubleToDouble(double number) {
        return (int) number;
    }

    public byte[] convertIntArrayToByteArray(int[] intArray) {
        byte[] byteArray = new byte[intArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            if (intArray[i] >= 0 && intArray[i] <= 127)
                byteArray[i] = (byte) intArray[i];
            else
                byteArray[i] = -1;
        }
        return byteArray;
    }

    public int getFirstDecimal(double number) {
        return (int) ((number - ((int) number)) * 10);
    }

}
