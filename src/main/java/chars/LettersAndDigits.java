package chars;

public class LettersAndDigits {

    public void printLetterOrDigit(String text) {

        for (char c: text.toCharArray()) {
            System.out.print(c + " : ");
            if (Character.isDigit(c))
                System.out.println("számjegy");
            else if (Character.isLetter(c))
                System.out.println("betű");
            else
                System.out.println("egyéb");
        }
    }

    public static void main(String[] args) {

        LettersAndDigits lettersAndDigits = new LettersAndDigits();
        lettersAndDigits.printLetterOrDigit("bfa68fF;X");

    }

}
