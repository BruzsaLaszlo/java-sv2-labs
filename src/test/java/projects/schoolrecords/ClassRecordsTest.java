package projects.schoolrecords;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ClassRecordsTest {

    private ClassRecords classRecords;
    private Tutor tutor = new Tutor("Nagy Csilla",
            Arrays.asList(new Subject("földrajz"),
                    new Subject("matematika"),
                    new Subject("biológia"),
                    new Subject("zene"),
                    new Subject("fizika"),
                    new Subject("kémia")));


    @BeforeEach
    void setUp() {
        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        firstStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("fizika"), tutor));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), tutor));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }

    @Test
    void testCreate() {
        assertEquals("Fourth Grade A", classRecords.getClassName());
    }

    @Test
    void testAddStudentAlreadyExists() {
        assertFalse(classRecords.addStudent(new Student("Nagy Béla")));
    }

    @Test
    void testAddStudent() {
        assertTrue(classRecords.addStudent(new Student("Nagy Klára")));
    }

    @Test
    void testRemoveStudent() {
        assertTrue(classRecords.removeStudent(new Student("Nagy Béla")));
    }

    @Test
    void testRemoveStudentDoesNotExists() {
        assertFalse(classRecords.removeStudent(new Student("Nagy Klára")));
    }

    @Test
    void emptyStudentListShouldThrowException() throws ArithmeticException {

        Exception ex = assertThrows(ArithmeticException.class, () -> new ClassRecords("First Grade", new Random()).calculateClassAverage());
        assertEquals("No student in the class, average calculation aborted!", ex.getMessage());

    }

    @Test
    void noMarksShouldThrowException() throws ArithmeticException {


        ClassRecords classRecords = new ClassRecords("First Grade", new Random());
        classRecords.addStudent(new Student("Nagy Béla"));


        Exception ex = assertThrows(ArithmeticException.class, classRecords::calculateClassAverage);
        assertEquals("No marks present, average calculation aborted!", ex.getMessage());
    }

    @Test
    void testCalculateClassAverage() {
        assertEquals(3.33, classRecords.calculateClassAverage());
    }

    @Test
    void testCalculateClassAverageBySubject() {
        //Given
        Subject geography = new Subject("földrajz");
        //Then
        assertEquals(2.75, classRecords.calculateClassAverageBySubject(geography));
    }

    @Test
    void emptyStudentNameShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> classRecords.findStudentByName(""));
        assertEquals("Student name must not be empty!", ex.getMessage());
    }

    @Test
    void emptyListShouldThrowException() throws IllegalStateException {
        Exception ex = assertThrows(IllegalStateException.class, () -> new ClassRecords("First Grade", new Random()).findStudentByName("Kovács Rita"));
        assertEquals("No students to search!", ex.getMessage());
    }

    @Test
    void nonExistingStudentShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> classRecords.findStudentByName("Kiss Rita"));
        assertEquals("Student by this name cannot be found! Kiss Rita", ex.getMessage());
    }

    @Test
    void testFindStudentByName() {
        assertEquals("Kovács Rita", classRecords.findStudentByName("Kovács Rita").getName());
    }

    @Test
    void emptyListException() throws IllegalStateException {
        Exception ex = assertThrows(IllegalStateException.class, () -> new ClassRecords("Fourth Grade", new Random()).repetition());
        assertEquals("No students to select for repetition!", ex.getMessage());
    }

    @Test
    void testRepetition() {
        assertEquals("Varga Márton", classRecords.repetition().getName());
    }

    @Test
    void testListStudyResults() {
        //Given
        List<StudyResultByName> list = classRecords.listStudyResults();
        //Then
        assertEquals("Kovács Rita", list.get(0).getStudentName());
        assertEquals(3.33, list.get(0).getStudyAverage());
        assertEquals(3, list.size());
    }

    @Test
    void testListStudentNames() {
        assertEquals("Kovács Rita, Nagy Béla, Varga Márton", classRecords.listStudentNames());
    }
}