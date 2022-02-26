package zarovizsgapotpotvizsga.uniquefinder;

import java.util.LinkedHashSet;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input is null");
        }

        return input.chars()
                .mapToObj(value -> (char) value)
                .collect(LinkedHashSet<Character>::new, LinkedHashSet::add, LinkedHashSet::addAll)
                .stream().toList();
    }
}
