package junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumbersTest {

    @Test
    void testGetEvenNumbers() {

        Numbers numbers = new Numbers();

        int[] anums = {2, 8, 5, 6, 2, 3, 9};

        int[] aExpected = {2, 8, 0, 6, 2, 0, 0};

        assertArrayEquals(aExpected, numbers.getEvenNumbers(anums));

    }
}
