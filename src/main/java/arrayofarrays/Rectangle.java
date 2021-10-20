package arrayofarrays;

public class Rectangle {

    public static int[][] rectangularMatrix(int size) {
        int[][] rm = new int[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                rm[i][j] = i;

        return rm;
    }

    public static void main(String[] args) {

        final int size = 10;

        int[][] rm = rectangularMatrix(size);

        for (int[] ints : rm) {
            for (int i : ints)
                System.out.print(i + " ");
            System.out.println();
        }

    }

}
