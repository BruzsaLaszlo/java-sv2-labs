package projects.schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ClassRecords {

    private String name;
    private Random random;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    public ClassRecords(String name) {
        this(name, new Random());
    }

    public boolean addStudent(Student student) {
        Objects.requireNonNull(student);
        if (students.contains(student)) {
            return false;
        } else {
            return students.add(student);
        }
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double sum = 0;
        for (Student student : students) {
            sum += student.calculateAverage();
        }

        double average = sum / students.size();
        if (average == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return average;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double sumOfAverages = 0;
        int count = 0;
        for (Student student : students) {
            double average = student.calculateSubjectAverage(subject);
            if (average > 0) {
                sumOfAverages += average;
                count++;
            }
        }
        return count == 0 ? 0 : sumOfAverages / count;
    }

    public Student findStudentByName(String name) {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        if (isNameValid(name)) {
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    return student;
                }
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    private boolean isNameValid(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        return true;
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(random.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> result = new ArrayList<>();
        for (Student student : students) {
            result.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return result;
    }

    public String listStudentNames() {
        StringBuilder names = new StringBuilder();
        boolean first = true;
        for (Student student : students) {
            if (first) {
                first = false;
            } else {
                names.append(", ");
            }
            names.append(student.getName());
        }
        return names.toString();
    }

    public String getClassName() {
        return name;
    }

    public Random getRandom() {
        return random;
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }
}
