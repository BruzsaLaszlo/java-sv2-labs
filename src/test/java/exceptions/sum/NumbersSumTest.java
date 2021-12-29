package exceptions.sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersSumTest {


    NumbersSum ns = new NumbersSum();


    @Test
    void getSumIntArray() {

        IllegalArgumentException nullException =
                assertThrows(IllegalArgumentException.class, () -> ns.getSum((int[]) null));
        assertEquals("numbers can't null!", nullException.getMessage());

        var numbers = new int[]{1, 2, 3};
        assertEquals(6,ns.getSum(numbers));

    }


    @Test
    void getSumStringArray() {

        IllegalArgumentException nullException =
                assertThrows(IllegalArgumentException.class, () -> ns.getSum((String[]) null));
        assertEquals("numbers can't null!", nullException.getMessage());

        String[] numbers = {"1", "2", "3"};
        assertDoesNotThrow(() -> ns.getSum(numbers));
        assertEquals(6, ns.getSum(numbers));

        String[] notAllNumber = {"1", "2", "c"};
        IllegalArgumentException iaeCauseNfe =
                assertThrows(IllegalArgumentException.class, () -> ns.getSum(notAllNumber));
        assertEquals(NumberFormatException.class, iaeCauseNfe.getCause().getClass());

    }
}