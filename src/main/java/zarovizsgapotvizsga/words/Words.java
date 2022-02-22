package zarovizsgapotvizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        long digitsCount = s.chars()
                .filter(Character::isDigit)
                .count();

        return digitsCount > s.length() >> 1;
    }

}
