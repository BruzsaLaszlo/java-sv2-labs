package methodchain;

public class ModifiedWord {

    private char[] subWord;

    public String modify(String word) {

        if (word == null || word.length() <= 3)
            throw new IllegalArgumentException("illegal word (too short)");

        subWord = word.substring(0,4).toCharArray();

        return toUpperCaseCharAt(0)
                .changeCharTo('x',1)
                .toUpperCaseCharAt(2)
                .changeCharTo('y', 3)
                .getWord();


    }

    private ModifiedWord toUpperCaseCharAt(int index) {
        subWord[index] = Character.toUpperCase(subWord[index]);

        return this;
    }

    private ModifiedWord changeCharTo(char newChar, int index) {
        subWord[index] = newChar;

        return this;
    }

    private String getWord() {
        return String.valueOf(subWord);
    }
}
