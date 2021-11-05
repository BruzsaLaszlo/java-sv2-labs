package arrayofarrays;

public class ArrayOfArrays {

    public void printArrayOfArrays(int[][] a) {

        for (int[] ints : a) {
            for (int i : ints)
                System.out.print(i + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {

        ArrayOfArrays arrayOfArrays = new ArrayOfArrays();

        int[][] a = new int[4][3];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = j;

        arrayOfArrays.printArrayOfArrays(a);

    }
}
