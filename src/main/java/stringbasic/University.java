package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents(Student student) {
        students.add(student);
    }

    public boolean areaEqual(Student student, Student anotherStudent) {
        return student.getNeptunCode().equals(anotherStudent.getNeptunCode()) &&
                student.getId().equals(anotherStudent.getId());
    }

    public List<Student> getStudents() {
        return students;
    }
}
