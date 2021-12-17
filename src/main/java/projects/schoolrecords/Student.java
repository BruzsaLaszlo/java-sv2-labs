package projects.schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isNameValid(name)) {
            this.name = name;
        }
    }

    public void grading(Mark mark) {
        Objects.requireNonNull(mark, "Mark must not be null!");
        marks.add(mark);
    }


    public double calculateAverage() {
        int sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getNumber();
        }
        return marks.size() == 0 ? 0 : (int) ((double) sum / marks.size() * 100) / 100d;
    }

    public double calculateSubjectAverage(Subject subject) {
        int sum = 0;
        int count = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().equals(subject)) {
                sum += mark.getMarkType().getNumber();
                count++;
            }
        }
        return count == 0 ? 0 : (int) ((double) sum / count * 100) / 100d;
    }

    @Override
    public String toString() {
        return String.format("%s marks: %s", name, getSubjectsAndMarks());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private Object getSubjectsAndMarks() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Mark mark : marks) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append(mark.getSubject())
                    .append(": ")
                    .append(mark.getMarkType());
        }
        return sb.toString();
    }

    private boolean isNameValid(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Mark> getMarks() {
        return List.copyOf(marks);
    }
}
