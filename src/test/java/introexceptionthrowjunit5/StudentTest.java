package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void addNotes() {
        Student student = new Student();
        IllegalArgumentException iae = assertThrows(
                IllegalArgumentException.class,
                () -> student.addNotes(0));
        assertEquals("Note must be between 1 and 5!", iae.getMessage());
    }
}