package zarovizsgapotvizsga2021.students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private String name;
    private String className;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public Student(String name, String className, List<Integer> grades) {
        this.name = name;
        this.className = className;
        this.grades = grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public List<Integer> getGrades() {
        return Collections.unmodifiableList(grades);
    }
}
