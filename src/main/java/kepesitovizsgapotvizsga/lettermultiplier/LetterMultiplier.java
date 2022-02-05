package kepesitovizsgapotvizsga.lettermultiplier;

import java.util.stream.Collectors;

public class LetterMultiplier {

    public String multiply(String input, int number) {
        validate(input, number);
        return input.chars()
                .mapToObj(value -> String.valueOf((char) value).repeat(number))
                .collect(Collectors.joining());
    }

    private void validate(String input, int number) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("input is null or empty");
        }
        if (number < 0) {
            throw new IllegalArgumentException("number is negative");
        }
    }


}
