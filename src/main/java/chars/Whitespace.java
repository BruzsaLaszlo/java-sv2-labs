package chars;

public class Whitespace {

    public String makeWhiteSpaceToStar(String text) {

        char[] replaced = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c))
                replaced[i] = '*';
            else
                replaced[i] = c;
        }

        return new String(replaced);

    }

    public static void main(String[] args) {

        Whitespace whitespace = new Whitespace();

        System.out.println(whitespace.makeWhiteSpaceToStar("úgy adja vissza a paraméterül kapott szöveget"));

    }

}
