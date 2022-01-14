package collectionsclass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.toCollection;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("There must be more balls than the winning numbers!");
        }

        var numbers = Stream
                .iterate(1, i -> i + 1)
                .limit(ballCount)
                .collect(toCollection(ArrayList::new));
        shuffle(numbers);
        return numbers
                .stream()
                .limit(lotteryType)
                .toList();
    }
}
