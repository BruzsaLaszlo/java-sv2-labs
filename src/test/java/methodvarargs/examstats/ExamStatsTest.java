package methodvarargs.examstats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamStatsTest {

    ExamStats es = new ExamStats(50);

    @Test
    void getNumberOfTopGrades() {

        assertThrows(IllegalArgumentException.class, () -> es.getNumberOfTopGrades(80));

        assertEquals(2, es.getNumberOfTopGrades(80,41,50,12,25,10,33));


    }

    @Test
    void hasAnyFailed() {

        assertThrows(IllegalArgumentException.class, () -> es.getNumberOfTopGrades(50));

        assertEquals(2, es.getNumberOfTopGrades(80,41,50,12,25,10,33));

    }
}