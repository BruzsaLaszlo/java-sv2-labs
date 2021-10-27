package stringbasic.characters;

/*
A menete az, hogy a tanár megad egy szót, amelyet az alkalmazás kér be tőle.
Ezután a program írja ki a konzolra, hogy ezt a szót le kell betűznie a tanulónak.
Majd az alkalmazás az egyenként beírt betűket írja ki a konzolra, írja ki a belőlük összeállítható szót,
és végül értékelje ki, hogy jól oldotta-e meg a tanuló a feladatot.
 */

import java.util.Scanner;

public class Words {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérek egy szót: ");
        String word = scanner.nextLine();

        System.out.println("Ezt a szót kell lebetűzni: " + word);

        String s = "";
        do {
            s += scanner.next();
        } while (word.length() != s.length());

        if (word.equals(s))
            System.out.println("Sikerült!");
        else
            System.out.println("Nem sikerült!");
    }

}
