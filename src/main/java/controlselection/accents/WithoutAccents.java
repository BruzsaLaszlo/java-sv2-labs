package controlselection.accents;

public class WithoutAccents {

    public char getWithoutAccents(char c) {

        switch (Character.toLowerCase(c)) {
            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ó':
            case 'ö':
            case 'ő': return 'o';
            case 'ú':
            case 'ü':
            case 'ű': return 'u';
            default: return c;
        }

    }

}
