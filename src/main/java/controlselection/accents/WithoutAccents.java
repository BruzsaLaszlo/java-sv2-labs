package controlselection.accents;

public class WithoutAccents {

    public char getWithoutAccents(char c) {

        switch (Character.toLowerCase(c)) {

            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ó',
                 'ö',
                 'ő': return 'o';
            case 'ú',
                 'ü',
                 'ű': return 'u';
            default:  return c;

        }

    }

}
