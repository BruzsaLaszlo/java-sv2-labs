package statements;

import java.util.Scanner;

/*
Készíts egy Time osztályt, amely egy adott időpontot reprezentál egy napon belül.
Három attribútuma az óra, perc és másodperc értékét tárolja egész számként. Ezeket a
a konstruktorban kapja meg. Készítsd el az alábbi metódusokat:

A getInMinutes() metódus az időpont értékét percekben adja vissza, de a másodperceket figyelmen kívül hagyja.
A getInSeconds() metódus a teljes időpontot másodpercben adja vissza.
Az earlierThan() metódus paraméterként egy másik Time típusú objektumot kap. Amennyiben az adott objektum által
 reprezentált időpont korábbi, mint a paraméterül kapott, igazat ad vissza, különben hamisat.
 Használd a már elkészített metódusokat!
A toString() metódusa az időpontot óra:perc:másodperc formában szövegként adja vissza.
A TimeMain osztály main() metódusában teszteld az osztályt! Kérj be a felhasználótól két időpontot,
 és írd ki az elsőt teljesen majd percekben, a másodikat teljesen majd másodpercekben, illetve azt,
 hogy az első korábbi-e, mint a második!

Egy lehetséges kimenet:

Az első időpont 12:3:43 = 723 perc
A második időpont 4:21:38 = 15698 másodperc
Az első korábbi, mint a második: false
 */
public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getInMinutes() {
        return hour * 60 + minute;
    }

    public int getInSeconds() {
        return hour * 3600 + minute * 60;
    }

    public boolean earlierThan(Time time) {
        return time.getInSeconds() > getInSeconds();
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    private static Time readTime() {

        int hour;
        int min;
        int sec;

        Scanner scanner = new Scanner(System.in);

        System.out.println("hour: ");
        hour = scanner.nextInt();

        System.out.println("minutes: ");
        min = scanner.nextInt();

        System.out.println("seconds: ");
        sec = scanner.nextInt();

        return new Time(hour, min, sec);
    }

    public static void main(String[] args) {

        Time t1 = readTime();
        System.out.println("first: " + t1 + " = " + t1.getInMinutes() + " minutes");

        Time t2 = readTime();
        System.out.println("second: " + t2 + " = " + t2.getInSeconds() + " seconds");

        System.out.println("first ealier than second : " + t1.earlierThan(t2));
    }
}
