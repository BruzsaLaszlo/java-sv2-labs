package lambdaintermediate;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingInt;

public class LongWords {

    private List<String> words;

    public LongWords(List<String> words) {
        this.words = words;
    }

    public long getNumberOfWordsStartWith(String keyWord) {
        return words.stream()
                .filter(s -> s.startsWith(keyWord))
                .count();
    }

    public List<String> getLongerWords(int number) {
        return words.stream()
                .filter(s -> s.length() > number)
                .toList();
    }

    public Optional<String> getShortestWordContainingGivenCharacter(char character) {
        return words.stream()
                .filter(s -> s.contains(String.valueOf(character)))
                .min(comparingInt(String::length));
    }
}
