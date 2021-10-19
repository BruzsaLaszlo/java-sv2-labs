package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {

        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználók felvétele");
        System.out.println("Többi: Kilépés");

        int num = new Scanner(System.in).nextInt();

        if (num == 1)
            System.out.println("Felhasználók listázása");
        else if (num == 2)
            System.out.println("Felhasználók felvétele");

    }
}
