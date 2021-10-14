package classstructureattributes;

/*
Hozz létre egy main() metódust a ClientMain osztályba, amelyben kipróbálod a Client osztály működését.
Példányosítani kell egy objektumot a Client osztály alapján, majd kérd be az attribútumok értékét a felhasználótól.
Ellenőrzésképp írd ki minden attribútumának értékét a konzolra!
 */

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Név: ");
        client.name = scanner.nextLine();
        System.out.println("Születési év: ");
        client.year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("address: ");
        client.address = scanner.nextLine();
        System.out.println("name: " + client.name);
        System.out.println("year: " + client.year);
        System.out.println("address: " + client.address);
    }
}
