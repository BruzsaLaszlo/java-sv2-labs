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
        String[] stringArray = {"S", "M", "L", "XL", "XXL"};

        arrayHandler.addIndexToNumber(intArray);

        for (int i : intArray)
            System.out.println(i);

        for (int i = 0; i < intArray.length; i++)
            if (i == intArray.length - 1)
                System.out.println(intArray[i]);
            else
                System.out.print(intArray[i] + ", ");


        arrayHandler.concatenateIndexToWord(stringArray);

        for (String s : stringArray)
            System.out.println(s);

        for (int i = 0; i < stringArray.length; i++)
            if (i == stringArray.length - 1)
                System.out.println(stringArray[i]);
            else
                System.out.print(stringArray[i] + ", ");

    }
}
