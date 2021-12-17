package projects.schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> subjects;

    public Tutor(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = new ArrayList<>(subjects);
    }

    public boolean tutorTeachingSubject(Subject subject) {
        return subjects.contains(subject);
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return List.copyOf(subjects);
    }
}
