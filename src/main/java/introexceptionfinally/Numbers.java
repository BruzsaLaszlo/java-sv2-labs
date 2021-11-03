package introexceptionfinally;

import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i;
        do{
            System.out.print("Kérek egy számot: ");
            try {
                i = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                throw new IllegalStateException("Nem számot adtál meg!");
            } finally {
                System.out.println("End of round.");
            }
        } while (i % 2 == 1);

    }

}
