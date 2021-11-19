package constructoroverloading.bus;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BusTimeTableTest {

    @Test
    void getNextBus() {

        var list = List.of(
                new SimpleTime(10, 10),
                new SimpleTime(12, 20),
                new SimpleTime(13, 30),
                new SimpleTime(14, 40)
        );

        BusTimeTable btt = new BusTimeTable(list);

        assertEquals("10:10", btt.getNextBus(new SimpleTime(9, 0)).toString());
        assertEquals("14:40", btt.getNextBus(new SimpleTime(14, 0)).toString());
        assertThrows(IllegalStateException.class, () -> btt.getNextBus(new SimpleTime(15, 0)));

    }
}