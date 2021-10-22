package algorithmsmax.hill;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HillTest {

    @Test
    void getMax() {

        Hill hill = new Hill();
        List<Integer> hills = Arrays.asList(1234,4323,2344,4756,5000,2343,4242,2123,1235);
        assertEquals(5000, hill.getMax(hills));

    }
}