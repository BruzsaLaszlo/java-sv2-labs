package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 1; i < 6; i++) {
            System.out.println("Kérem az " + i + ". számot: ");
            sum += scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("A számok összege: " + sum);

    }
}
