package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kerem az adatokat: ");
        BankAccount acc= new BankAccount(scanner.nextLine(),scanner.nextLine(), scanner.nextInt());
        System.out.println(acc.getInfo());
        acc.deposit(100_000);
        System.out.println(acc.getInfo());
        acc.withdraw(50_000);
        System.out.println(acc.getInfo());
    }
}
