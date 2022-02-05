package kepesitovizsgapotvizsga.forest;

import java.util.Collections;
import java.util.List;

public class Forest {

    private List<Tree> trees;

    public Forest(List<Tree> trees) {
        this.trees = trees;
    }

    public void rain() {
        trees.forEach(Tree::irrigate);
    }

    public void cutTrees(Lumberjack lumberjack) {
        trees.removeIf(lumberjack::canCut);
    }

    public boolean isEmpty() {
        return trees.isEmpty();
    }

    public List<String> getStatus() {
        return trees.stream()
                .map(Tree::toString)
                .toList();
    }

    public List<Tree> getTrees() {
        return Collections.unmodifiableList(trees);
    }
}
