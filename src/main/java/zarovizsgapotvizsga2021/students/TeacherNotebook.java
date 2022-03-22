package zarovizsgapotvizsga2021.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TeacherNotebook {

    private List<Student> students = Collections.emptyList();


    public List<String> findFailingStudents() {
        return students.stream()
                .filter(this::isFailing)
                .map(Student::getName)
                .toList();
    }

    private boolean isFailing(Student student) {
        double average = student.getGrades().stream()
                .mapToInt(value -> value)
                .summaryStatistics()
                .getAverage();
        return average < 2;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void readFromFile(Path path) {
        students = getLinesFromFile(path).stream()
                .map(this::parseStudent)
                .toList();
    }

    private Student parseStudent(String line) {
        var data = line.split(";");
        List<Integer> grades = Arrays.stream(data)
                .skip(2)
                .map(Integer::parseInt)
                .toList();
        return new Student(data[0], data[1], grades);
    }

    private List<String> getLinesFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file: " + path, ioe);
        }
    }

}
