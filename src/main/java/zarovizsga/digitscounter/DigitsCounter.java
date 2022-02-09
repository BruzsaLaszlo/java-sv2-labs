package zarovizsga.digitscounter;

import java.util.stream.Collectors;

public class DigitsCounter {

    public int getCountOfDigits(String input) {
        if (input == null) return 0;
        return input.chars()
                .filter(Character::isDigit)
                .boxed()
                .collect(Collectors.toSet()).size();
    }

}
