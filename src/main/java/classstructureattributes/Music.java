package classstructureattributes;

import java.util.Scanner;

/*
Készíts main() metódust egy Music osztályba, ahol kérd be a felhasználótól a kedvenc zeneszáma adatait! Ellenőrzésképp
írd ki a megadott adatokat előadó - cím (hossz percben) formában, azaz Britney Spears - Oops!...I Did It Again (4 perc)!
 */
public class Music {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Song song = new Song();
        System.out.println("band: ");
        song.band = scanner.nextLine();
        System.out.println("title: ");
        song.title = scanner.nextLine();
        System.out.println("length: ");
        song.length = scanner.nextInt();
        System.out.println(song.band + " - " + song.title + "(" + song.length + ")");
    }
}
