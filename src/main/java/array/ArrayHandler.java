package array;

public class ArrayHandler {

    public static void addIndexToNumber(int[] source) {
        for (int i = 0; i < source.length; i++)
            source[i] += i;
    }

    public static void concatenateIndexToWord(String[] source) {
        for (int i = 0; i < source.length; i++)
            source[i] = i + ". " + source[i];
    }

    public static void main(String[] args) {
        int[] intArray = {1, 1, 1, 1, 10};
        String[] stringArray = {"S", "M", "L", "XL", "XXL"};

        addIndexToNumber(intArray);

        for (int i : intArray)
            System.out.println(i);

        for (int i = 0; i < intArray.length; i++)
            if (i == intArray.length - 1)
                System.out.println(intArray[i]);
            else
                System.out.print(intArray[i] + ", ");


        concatenateIndexToWord(stringArray);

        for (String s : stringArray)
            System.out.println(s);

        for (int i = 0; i < stringArray.length; i++)
            if (i == stringArray.length - 1)
                System.out.println(stringArray[i]);
            else
                System.out.print(stringArray[i] + ", ");

    }
}
