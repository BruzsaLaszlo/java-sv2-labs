package lambdastreams.baseoperations;

import java.util.List;
import java.util.Optional;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min() {
        return numbers.stream().min(Integer::compareTo);
    }

    public int sum() {
        return numbers.stream().reduce(0, Integer::sum, Integer::sum);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(number -> number > 0);
    }

    public List<Integer> getDistinctElements() {
        return numbers.stream().distinct().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
