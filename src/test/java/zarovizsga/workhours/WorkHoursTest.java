package zarovizsga.workhours;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkHoursTest {

    @Test
    void minWork() {
        WorkHours workHours = new WorkHours();
        String result = workHours.minWork("src/test/resources/workhours.txt");
        assertEquals("John Doe: 2021-01-04", result);
    }
}