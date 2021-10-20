package looptypes;

public class Sum {

    public static String printSums(int[] numbers) {

        String sums = "";
        for (int i = 0; i < numbers.length - 1; i++)
            sums += numbers[i] + numbers[i + 1] + " ";

        return sums;

    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6, 1, 3, 4};
        System.out.println(printSums(nums));

    }

}
