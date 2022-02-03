package kepesitovizsga.potpotvizsga;

import java.util.stream.IntStream;

public class NumberOfDigits {

    public int getNumberOfDigits(int number) {
        int count = 0;
        for (int j = 1, i = 1; i <= number; i++, count++, j = i)
            while ((j /= 10) > 0)
                count++;
        return count;
    }

    public int getNumberOfDigits2(int number) {
        return IntStream.rangeClosed(1, number)
                .map(this::getDigitsOf)
                .sum();
    }

    private int getDigitsOf(int i) {
        int count = 1;
        while ((i /= 10) > 0) {
            count++;
        }
        return count;
    }

    public int getNumberOfDigits3(int number) {
        return IntStream.rangeClosed(1, number)
                .mapToObj(String::valueOf)
                .mapToInt(String::length)
                .sum();
    }
}
