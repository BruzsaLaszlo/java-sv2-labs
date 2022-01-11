package collectionsset;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuestionGame {

    private List<RigthAnswer> rigthAnswers;
    private static final int WINNERS = 5;
    Random random = new Random();

    public QuestionGame(List<RigthAnswer> rigthAnswers) {
        this.rigthAnswers = rigthAnswers;
    }

    public Set<String> drawWinners() {
        var result = new HashSet<String>();
        while (result.size() != WINNERS) {
            if (rigthAnswers.isEmpty()) {
                throw new IllegalArgumentException("nincs elég játékos");
            }
            RigthAnswer drawn = rigthAnswers.get(random.nextInt(rigthAnswers.size()));
            result.add(drawn.getName());
            rigthAnswers.remove(drawn);
        }
        return result;
    }

}
