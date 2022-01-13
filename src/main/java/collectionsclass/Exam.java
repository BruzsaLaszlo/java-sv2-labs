package collectionsclass;

import java.util.Collections;
import java.util.List;

public class Exam {

    private List<ExamResult> examResults;

    public Exam(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public List<String> getNamesOfSucceededPeople(int places) {
        return examResults.stream()
                .sorted(Collections.reverseOrder())
                .limit(places)
                .map(ExamResult::name)
                .toList();
    }
}
