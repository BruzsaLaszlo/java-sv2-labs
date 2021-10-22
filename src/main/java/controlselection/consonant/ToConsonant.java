package controlselection.consonant;

public class ToConsonant {

    public char getNext(char c) {

        switch (Character.toLowerCase(c)) {
            case 'a' : return 'b';
            case 'e' : return 'f';
            case 'i' : return 'j';
            case 'o' : return 'p';
            case 'u' : return 'v';
            default: return c;
        }

    }

}
