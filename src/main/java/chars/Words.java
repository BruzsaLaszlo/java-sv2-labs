package chars;

public class Words {

    public String pushWord(String word) {

        char[] push = new char[word.length()];
        for (int i = 0; i < word.length(); i++)
            push[i] = (char) (word.charAt(i) + 1);

        return new String(push);

    }

    public static void main(String[] args) {

        Words words = new Words();

        System.out.println(words.pushWord("alma"));

    }

}
