package introexceptionthrow;

import java.util.Scanner;

public class ShortWord {

    public static void main(String[] args) {

        System.out.print("Kérek egy legfeljebb 5 betűs szót: ");
        String word = new Scanner(System.in).nextLine();

        if (word.length() > 5)
            throw new IllegalArgumentException("A szó hosszabb mint 5 karakter: " + word);

        for(char c : word.toCharArray())
            if (!Character.isLetter(c))
                throw new IllegalArgumentException("A szó nem csak betűket tartalmaz: " + word);

        System.out.println(word);

    }

}
