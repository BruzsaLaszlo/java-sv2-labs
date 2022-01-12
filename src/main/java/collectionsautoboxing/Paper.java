package collectionsautoboxing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Paper {

    private Map<String, Integer> paper = new HashMap<>();

    public void putFurtherPaper(String className, int kilogramms) {
        if (!paper.keySet().contains(className)) {
            paper.put(className, 0);
        }
        paper.put(className, paper.get(className) + kilogramms);
    }

    public String getWinnerClass() {
        return paper.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElseThrow().getKey();
//        Map.Entry<String, Integer> winner = paper.entrySet().stream().findFirst().orElseThrow();
//        for (var entry : paper.entrySet()) {
//            if (winner.getValue() < entry.getValue()) {
//                winner = entry;
//            }
//        }
//        return winner.getKey();
    }

    public int getTotalWeight() {
        return paper.values().stream().mapToInt(i -> i).sum();
//        int sum =0;
//        for (var entry : paper.entrySet()) {
//            sum += entry.getValue();
//        }
//        return sum;
    }


    public Map<String, Integer> getPaper() {
        return Map.copyOf(paper);
    }
}
