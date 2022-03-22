package zarovizsgapotpotvizsga2021.learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ExamLearningsTest {

    ExamLearnings examLearnings;

    @BeforeEach
    void init() {
        examLearnings = new ExamLearnings();
        examLearnings.readFromFile(Paths.get("src/test/resources/zarovizsgapotpotvizsga2021/examlearnings.csv"));
    }

    @Test
    void testReadFromFile() {
        assertEquals(5, examLearnings.getLearnings().size());
        assertEquals(120, examLearnings.getLearnings().get("Jonathan Doe"));
        assertTrue(examLearnings.getLearnings().containsKey("Jane Doe"));
    }

    @Test
    void testReadFromNotExistingFile() {
        Exception ex = assertThrows(IllegalStateException.class,
                () -> examLearnings.readFromFile(Paths.get("src/test/resources/zarovizsgapotpotvizsga2021/xyz.csv")));
        assertEquals("Cannot read file.", ex.getMessage());
    }

    @Test
    void testGetAverageLearningInMinutes() {
        assertEquals(321.0, examLearnings.getAverageLearningInMinutes());
    }

    @Test
    void testGetAverageLearningWhenNoTimeValues() {
        examLearnings = new ExamLearnings();

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> examLearnings.getAverageLearningInMinutes());
        assertEquals("There are no learning times.", ex.getMessage());
    }
}