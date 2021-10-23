package controliteration.exit;

import java.util.Scanner;

public class Exit {
    public static void main(String[] args) {

        System.out.println("Az ügyfélszolgálat menüje jelenleg nem elérhető.");
        System.out.println("     Kilépés: x billentyű megnyomásával");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        boolean b;
        do {
            b = scanner.nextLine().equalsIgnoreCase("x");
        } while (!b);

    }
}
