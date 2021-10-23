package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem a létszámot: ");
        int letszam = scanner.nextInt();

        if (letszam > 10)
            System.out.println(letszam - 10 + " ember maradt a parton");
        else {
            if (letszam >= 5) {
                System.out.println("Elvittek az öt személyes csónakot!");
                letszam -= 5;
            } else
                System.out.println("Az öt személyes csónak megmaradt!");
            if (letszam >= 3) {
                System.out.println("Elvittek az három személyes csónakot!");
                letszam -= 3;
            } else
                System.out.println("A három személyes csónak megmaradt!");
            if (letszam > 0) {
                System.out.println("Elvittek az két személyes csónakot!");
            } else {
                System.out.println("A két személyes csónak megmaradt!");
            }
        }
    }
}

