package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassRoomTest {

    @Test
    void constructorTest() {
        //Given
        ClassRoom classroom = new ClassRoom("122", 20, Facility.CHALKBOARD);
        //Then
        assertEquals("122", classroom.getLocation());
        assertEquals(20, classroom.getCapacity());
        assertEquals(Facility.CHALKBOARD, classroom.getFacility());
    }

    @Test
    void isSuitableSuccess() {
        //Given
        ClassRoom classroom = new ClassRoom("122", 20, Facility.COMPUTERS);
        Course course = new Course(15, Facility.COMPUTERS);
        //Then
        assertTrue(classroom.isSuitable(course));

    }

    @Test
    void isSuitableFail() {
        //Given
        ClassRoom classroom = new ClassRoom("122", 20, Facility.COMPUTERS);
        Course course = new Course(15, Facility.CHALKBOARD);
        //Then
        assertFalse(classroom.isSuitable(course));
    }
}