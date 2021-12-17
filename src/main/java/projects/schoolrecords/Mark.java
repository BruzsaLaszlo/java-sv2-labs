package projects.schoolrecords;

import java.util.Objects;

public class Mark {

    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    private Mark(Subject subject, Tutor tutor) {
        Objects.requireNonNull(subject, "Both subject and tutor must be provided!");
        Objects.requireNonNull(tutor, "Both subject and tutor must be provided!");
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        this(subject, tutor);
        this.markType = markType;
    }

    public Mark(String martType, Subject subject, Tutor tutor) {
        this(subject, tutor);
        this.markType = MarkType.valueOf(martType);
    }

    @Override
    public String toString() {
        return markType.toString();
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
