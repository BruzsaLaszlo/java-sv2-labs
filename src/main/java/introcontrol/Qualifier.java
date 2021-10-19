package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {

        System.out.println("Kérek egy számot: ");
        int num = new Scanner(System.in).nextInt();
        if (num > 100)
            System.out.println("Nagyobb mint száz");
        else
            System.out.println("Száz vagy kisebb");
    }
}
