package zarovizsgapotpotvizsga2021.numbers;

import java.util.List;

public class RisingNumbers {


    public int getNumberOfSixDigitRisingNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("There are no numbers!");
        }

        return (int) numbers.stream()
                .map(String::valueOf)
                .filter(number -> number.length() == 6)
                .filter(this::isRaising)
                .count();
    }

    private boolean isRaising(String number) {
        for (int i = 0; i < 5; i++) {
            if (number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
