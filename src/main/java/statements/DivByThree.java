package statements;

import java.util.Scanner;

/*
Írj egy main() metódust a DivByThree,
 osztályba, mely bekér egy egész számot a felhasználótól, majd kiírja, hogy 3-mal osztható-e!
 */
public class DivByThree {
    public static void main(String[] args) {
        System.out.println("Kérek egy számot: ");
        Scanner scanner = new Scanner(System.in);
        int i =scanner.nextInt();
        System.out.println(i % 3 == 0 ? "Oszthato 3-al" : "Nem oszthato 3-al");
    }
}
