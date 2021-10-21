package looptypesmodify;

import java.util.Arrays;

public class EveryThird {

    public int[] changeToZero(int[] numbers) {

        int[] nums = Arrays.copyOf(numbers, numbers.length);

        for (int i = nums.length - 1; i >= 0; i -= 3)
            nums[i] = 0;

        return nums;

    }

    public static void main(String[] args) {

        EveryThird everyThird = new EveryThird();

        int[] numbers = {2, 6, 3, 5, 7, 2, 6, 2, 3, 5, 7, 3, 2, 9};

        int[] numsToZero = everyThird.changeToZero(numbers);

        System.out.println(Arrays.toString(numsToZero));

    }

}
