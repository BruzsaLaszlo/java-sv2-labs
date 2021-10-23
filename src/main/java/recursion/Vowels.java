package recursion;

public class Vowels {

    public int getNumberOfVowels(String word) {

        if (word.length() > 0) {
            int count = switch (word.charAt(0)) {
                case 'a', 'e', 'i', 'o', 'u' -> 1;
                default -> 0;
            };
            return count + getNumberOfVowels(word.substring(1));
        }
        return 0;
    }

}
