package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void getSum() {

        Numbers numbers = new Numbers();
        int[] nums = {0, 0, 0, 0, 1, 2, 3, 4};
        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] nums3 = {0, 100, 0, 0, 0, 100, 0, 0};

        assertEquals(10,numbers.getSum(nums));
        assertEquals(0,numbers.getSum(nums2));
        assertEquals(200,numbers.getSum(nums3));

    }
}