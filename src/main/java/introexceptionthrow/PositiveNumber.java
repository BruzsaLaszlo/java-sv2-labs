package introexceptionthrow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PositiveNumber {

    public static void main(String[] args) {

        System.out.println("Kérek egy számot: ");
        String s = new Scanner(System.in).nextLine();

        try {
            int i = Integer.parseInt(s);
            if (i < 1)
                throw new IllegalArgumentException("not positive: " + i);
        } catch (InputMismatchException inputMismatchException) {
            throw new IllegalArgumentException("this is not a NUMBER");
        }

    }

}
