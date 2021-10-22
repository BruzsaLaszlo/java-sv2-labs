package algorithmssum.school;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @Test
    void testGetNumberOfStudents() {

        School school = new School();
        List<Integer> headcounts = Arrays.asList(25, 25, 20, 20, 30, 25, 25, 25);
        assertEquals(195, school.getNumberOfStudents(headcounts));
    }

}