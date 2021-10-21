package classstructureio;

import java.util.Scanner;

/*
Készíts egy Registration osztályt a classstructureio csomagba! A main metódusban kérd be a felhasználótól a
nevét és az email címét, majd írd ki, hogy milyen adatokkal regisztrált!
 */
public class Registration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a nevét: ");
        String name = scanner.nextLine();

        System.out.println("Kérem az email címét: ");
        String email = scanner.nextLine();

        System.out.println("Ezzel a névvel regisztrált: " + name);
        System.out.println("és ezzel az email címmel: "+ email);

    }

}
