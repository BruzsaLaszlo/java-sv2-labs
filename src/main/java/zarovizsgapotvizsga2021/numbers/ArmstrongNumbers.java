package zarovizsgapotvizsga2021.numbers;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        validate(number);

        List<Integer> numbers = getNumbers(number);
        long sum = numbers.stream()
                .mapToLong(value -> (int) Math.pow(value, numbers.size()))
                .sum();

        return number == sum;
    }

    private List<Integer> getNumbers(int number) {
        List<Integer> result = new ArrayList<>();
        while (number != 0) {
            result.add(number % 10);
            number /= 10;
        }
        return result;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
    }

}
