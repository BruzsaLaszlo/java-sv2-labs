package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        final double number = 2 + 2 - 1 * (6.6 / 2);
        System.out.println(number);

        System.out.println("2 + 2 - 1 * (6 / 2) =");
        double userAnswer = new Scanner(System.in).nextDouble();

        if (Math.abs(userAnswer) - number < 0.0001 )
            System.out.println("Helyes a válasz!");
        else
            System.out.println("Helytelen a válasz!");

    }

}
