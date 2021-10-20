package arrays;

import java.util.Arrays;

public class ArraysMain {

    public static String numberOfDaysAsString() {

        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);

    }

    public static String multiplicationStringAsTables(int size) {

        int[][] mt = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                mt[i][j] = (i + 1) * (j + 1);

        return Arrays.deepToString(mt);
    }

    public static boolean sameTempValues(double[] day, double[] anotherDay) {

        return Arrays.equals(day, anotherDay);

    }


    public static boolean sameTempValuesDayLight(double[] day, double[] anotherDay) {

        if (day.length == anotherDay.length)
            return Arrays.equals(day, anotherDay);
        if (day.length < anotherDay.length)
            return Arrays.equals(day, Arrays.copyOf(anotherDay, 23));
        else
            return Arrays.equals(Arrays.copyOf(day, 23), anotherDay);

    }

    public static boolean wonLottery(int[] sorsolt, int[] megjatszott) {

        int[] s = Arrays.copyOf(sorsolt, sorsolt.length);
        Arrays.sort(s);

        int[] m = Arrays.copyOf(megjatszott, megjatszott.length);
        Arrays.sort(m);

        return Arrays.equals(s, m);
    }

    public static void main(String[] args) {

        System.out.println(numberOfDaysAsString());
        System.out.println(multiplicationStringAsTables(4));

    }
}
