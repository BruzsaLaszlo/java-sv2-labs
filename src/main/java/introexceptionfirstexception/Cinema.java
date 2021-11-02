package introexceptionfirstexception;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Kérem a nevet: ");
        String name = sc.nextLine();

        System.out.println("Kérem a film címét: ");
        String title = sc.nextLine();

        System.out.println("Hány jegyet szeretne: ");
        int count = sc.nextInt();
        sc.nextLine();

        System.out.println("Melyik sorban: ");
        int row = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < count + 1; i++) {
            sb.append(row).append(".sor ").append(i).append(". szék");
            if (i != count)
                sb.append(", ");
        }

        System.out.printf(
                "A mozijegy.hu rendszerben vásárolt jegyek adatai a következők: \n" +
                        "Vásárló neve: %s\n" +
                        "Film címe: %s\n" +
                        "Lefoglalt helyek: %s\n" +
                        "Jó szórakozást!", name, title, sb);

    }

}
