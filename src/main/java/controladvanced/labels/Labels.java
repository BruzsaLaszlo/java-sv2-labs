package controladvanced.labels;

public class Labels {

    public int[][] getTableOfNumbers(int number) {

        int[][] table = new int[number][number];
        table[0][0] = 1;

        for (int i = 0; i < number; i++) {
            if (i == 5)
                continue;
            for (int j = 0; j < number; j++) {
                if (j == 7)
                    break;
                else
                    table[i][j] = (i + 1) + (j + 1);
            }
        }

        return table;

    }

}
