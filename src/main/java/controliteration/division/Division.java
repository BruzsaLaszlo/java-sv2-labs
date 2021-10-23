package controliteration.division;

import java.util.Scanner;

public class Division {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy pozitív egész számot! A program ennél kisebb számokat fog kiíírni.");
        int num1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hánnyal osztható számokat szeretne kapni?");
        int num2 = scanner.nextInt();
        scanner.nextLine();

        System.out.println();
        System.out.print("for:    ");

        for (int i = 1; i < num1; i++) {
            if (i % num2 == 0) {
                System.out.print(i + ", ");
            }
        }

        System.out.println();
        System.out.print("while:  ");

        int i = 1;
        while (i < num1) {
            if (i % num2 == 0) {
                System.out.print(i + ", ");
            }
            i++;
        }

    }

}
