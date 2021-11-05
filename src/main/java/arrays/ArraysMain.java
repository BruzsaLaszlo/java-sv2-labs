package arrays;

import java.util.Arrays;

public class ArraysMain {

    public String numberOfDaysAsString() {

        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);

    }

    public String multiplicationStringAsTables(int size) {

        int[][] mt = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                mt[i][j] = (i + 1) * (j + 1);

        return Arrays.deepToString(mt);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {

        return Arrays.equals(day, anotherDay);

    }


    public boolean sameTempValuesDayLight(double[] day, double[] anotherDay) {

        if (day.length == anotherDay.length)
            return Arrays.equals(day, anotherDay);
        if (day.length < anotherDay.length)
            return Arrays.equals(day, Arrays.copyOfRange(anotherDay, 0,23));
        else
            return Arrays.equals(Arrays.copyOfRange(day, 0,23), anotherDay);

    }

    public boolean wonLottery(int[] sorsolt, int[] megjatszott) {

        int[] s = Arrays.copyOf(sorsolt, sorsolt.length);
        Arrays.sort(s);

        int[] m = Arrays.copyOf(megjatszott, megjatszott.length);
        Arrays.sort(m);

        return Arrays.equals(s, m);
    }

    public static void main(String[] args) {

        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println(arraysMain.multiplicationStringAsTables(4));

    }
}
