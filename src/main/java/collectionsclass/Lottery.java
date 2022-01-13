package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("There must be more balls than the winning numbers!");
        }

        var numbers = Stream
                .iterate(1, i -> i + 1)
                .limit(ballCount)
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(numbers);
        return numbers
                .stream()
                .limit(lotteryType)
                .toList();
    }
}
