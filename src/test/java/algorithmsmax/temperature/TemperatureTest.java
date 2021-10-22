package algorithmsmax.temperature;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void getMin() {

        Temperature temperature = new Temperature();
        List<Integer> temps = Arrays.asList(23,12,34,23,23,12,15,11,25,24);
        assertEquals(11, temperature.getMin(temps));

    }
}