package arrayofarrays;

public class Triangular {

    public static int[][] triangularMatrix(int size) {

        int[][] tm = new int[size][];

        for (int i = 0; i < size; i++) {
            tm[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++)
                tm[i][j] = i;
        }

        return tm;
    }

    public static void main(String[] args) {

        final int size = 10;

        int[][] tm = triangularMatrix(size);

        for (int[] ints : tm) {
            for (int i : ints)
                System.out.print(i + " ");
            System.out.println();
        }

    }
}
