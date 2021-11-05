package array;

public class ArrayHandler {

    public void addIndexToNumber(int[] source) {

        for (int i = 0; i < source.length; i++)
            source[i] += i;

    }

    public void concatenateIndexToWord(String[] source) {

        for (int i = 0; i < source.length; i++)
            source[i] = i + ". " + source[i];

    }


    public static void main(String[] args) {

        ArrayHandler arrayHandler = new ArrayHandler();


        int[] intArray = {1, 1, 1, 1, 10};
        arrayHandler.addIndexToNumber(intArray);

        for (int i : intArray)
            System.out.println(i);

        for (int i = 0; i < intArray.length; i++)
            if (i == 0)
                System.out.print(intArray[i]);
            else
                System.out.print(", " + intArray[i]);


        System.out.println();


        String[] stringArray = {"S", "M", "L", "XL", "XXL"};
        arrayHandler.concatenateIndexToWord(stringArray);

        for (String s : stringArray)
            System.out.println(s);

        for (int i = 0; i < stringArray.length; i++)
            if (i == 0)
                System.out.print(stringArray[i]);
            else
                System.out.print(", " + stringArray[i]);

    }
}
