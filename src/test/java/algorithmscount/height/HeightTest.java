package algorithmscount.height;

import algorithmscount.height.Height;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightTest {

    @Test
    void testCountChildrenWithHeightGreaterThan() {

        Height height = new Height();
        List<Integer> heights = Arrays.asList(56,76,54,23,54,67,87,67,87);
        assertEquals(2, height.countChildrenWithHeightGreaterThan(heights, 80));

    }
}