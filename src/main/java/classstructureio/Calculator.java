package classstructureio;

import java.util.Scanner;

/*
Készíts egy Calculator osztályt a classstructureio csomagba! A main metódusban kérj be a felhasználótól két egész számot!
 Az első sorban írd ki a műveletet a következő formátumban: 5 + 10! A második sorban írd ki az eredményt (15)!
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérek egy számot: ");
        int i = scanner.nextInt();
        System.out.println("Kérek még egyet: ");
        int j = scanner.nextInt();
        System.out.println(i + "+" + j);
        System.out.println(i+j);
    }
}
