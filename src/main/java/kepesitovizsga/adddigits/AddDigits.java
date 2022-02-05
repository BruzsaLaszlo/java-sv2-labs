package kepesitovizsga.adddigits;

public class AddDigits {


    public int addDigits2(String input) {
        if (input == null || input.isBlank()) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.digit(c, 10);
            }
        }
        return sum;
    }

    public int addDigits(String input) {
        if (input == null || input.isBlank()) {
            return -1;
        }

        return input.chars()
                .filter(Character::isDigit)
                .map(digit -> Character.digit(digit, 10))
                .sum();
    }
}
