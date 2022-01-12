package collectionsset;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuestionGame {

    private List<RightAnswer> rightAnswers;
    private static final int WINNERS = 5;
    Random random = new Random();

    public QuestionGame(List<RightAnswer> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Set<String> drawWinners() {
        var result = new HashSet<String>();
        while (result.size() != WINNERS) {
            if (rightAnswers.isEmpty()) {
                throw new IllegalArgumentException("Not enough right answers!");
            }
            RightAnswer drawn = rightAnswers.get(random.nextInt(rightAnswers.size()));
            result.add(drawn.getName());
            rightAnswers.remove(drawn);
        }
        return result;
    }

}
