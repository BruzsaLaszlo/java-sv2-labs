package aslist;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Favourites {

    public static void main(String[] args) {

        List<String> favouriteThings;

        Scanner scanner = new Scanner(System.in);
        String[] favs = new String[3];

        System.out.println("Kedvenc filmed: ");
        favs[0] = scanner.nextLine();

        System.out.println("Kedvenc színed: ");
        favs[1] = scanner.nextLine();

        System.out.println("Kedvenc autód: ");
        favs[2] = scanner.nextLine();

        favouriteThings = Arrays.asList(favs);

        System.out.println(favouriteThings);
        System.out.println(favouriteThings.size());

    }
}
