package introexceptiontrycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1, num2;
        try {
            System.out.println("Kérem az elsö számot: ");
            num1 = sc.nextInt();
            sc.nextLine();

            System.out.println("Kérem a második számot: ");
            num2 = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
            System.out.println("Kivétel kezelve!");
            return;
        }

        int result;
        try {
            System.out.println("Kérem a müveleti jelet: ");
            char c = sc.nextLine().charAt(0);
            switch (c) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '/' -> result = num1 / num2;
                case '*' -> result = num1 * num2;
                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
        } catch (StringIndexOutOfBoundsException exception) {
            exception.printStackTrace();
            System.out.println("Kivétel kezelve!");
            return;
        } catch (IllegalStateException e){
            e.printStackTrace();
            System.out.println("Kivétel kezelve!");
            return;
        }

        System.out.println(result);

    }

}
