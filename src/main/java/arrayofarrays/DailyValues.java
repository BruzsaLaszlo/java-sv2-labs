package arrayofarrays;

public class DailyValues {

    public static final int MONTHS = 12;

    public int[][] getValues() {

        int[][] dom = new int[MONTHS][];

        for (int i = 0; i < MONTHS; i++) {
            int size;
            if (i == 1)
                size = 28;
            else if (i < 7)
                size = i % 2 == 0 ? 31 : 30;
            else
                size = i % 2 == 0 ? 30 : 31;

            dom[i] = new int[size];
        }

        return dom;
    }

    public static void main(String[] args) {

        DailyValues dailyValues = new DailyValues();

        int[][] dom = dailyValues.getValues();

        for (int i = 0; i < MONTHS; i++) {
            for (int j = 0; j < dom[i].length; j++)
                System.out.print(dom[i][j]);
            System.out.println(" : " + dom[i].length);
        }

    }

}
