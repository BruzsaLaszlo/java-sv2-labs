package statements;

import java.util.Scanner;

public class InvestmentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int found, interestRate;

        System.out.println("Kérem a befektetés összegét: ");
        found = scanner.nextInt();

        System.out.println("Kérem a kamatlábat: ");
        interestRate = scanner.nextInt();

        Investment investment = new Investment(found, interestRate);
        System.out.println("Tőke: " + investment.getFound());
        System.out.println("Hozam 50 napra: " + investment.getYield(50));
        System.out.println("Kivett összeg 80 nap után: " + investment.close(80));
        System.out.println("Kivett összeg 90 nap után: " + investment.close(90));
    }
}
