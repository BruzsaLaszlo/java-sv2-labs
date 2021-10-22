package junit5assert;

import java.util.Arrays;

public class Numbers {

    public int[] getEvenNumbers(int[] numbers) {

        int[] nums = Arrays.copyOf(numbers, numbers.length);

        for(int i = 0; i < nums.length; i++)
            if (nums[i] % 2 == 1)
                nums[i] = 0;

        return nums;

    }

}
