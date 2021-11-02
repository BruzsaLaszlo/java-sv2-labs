package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Kérek egy modatot mely több tagmondatból áll, " +
                "és azokat ugyanaz a karaktersorozat (például vessző és szóköz) választja el egymástól: ");
        String em = sc1.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Kérek egy modatot mely több tagmondatból áll, " +
                "és azokat ugyanaz a karaktersorozat (például vessző és szóköz) választja el egymástól: ");
        String mm = sc2.nextLine();

        sc2 = new Scanner(mm).useDelimiter(", ");
        while (sc2.hasNext())
            System.out.println(sc2.next());

    }

}
