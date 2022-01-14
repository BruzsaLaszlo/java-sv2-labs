package collectionsclass;

import java.util.Objects;

public record ExamResult(String name, int score) implements Comparable<ExamResult> {

    @Override
    public int compareTo(ExamResult o) {
        return score - o.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamResult that = (ExamResult) o;
        return score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
