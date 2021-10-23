package algorithmsdecision.town;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TownTest {

    @Test
    void containsFewerHabitants() {

        Town town = new Town();

        List<Integer> habitants = Arrays.asList(1234, 5435, 2342, 7655, 2342, 1200, 1562, 4235, 4323);

        assertEquals(true, town.containsFewerHabitants(habitants,2021));
        assertEquals(false, town.containsFewerHabitants(habitants,1021));
        assertEquals(true, town.containsFewerHabitants(habitants,1201));

    }
}