package introexceptiontrycatchtrace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMain {

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
            exceptionHandler(exception);
            return;
        }

        int result;
        Calculator calc = new Calculator();
        try {
            System.out.println("Kérem a müveleti jelet: ");
            char c = sc.nextLine().charAt(0);
            switch (c) {
                case '+' -> result = calc.add(num1, num2);
                case '-' -> {
                    try {
                        result = calc.subtract(num1, num2);
                    } catch (ArithmeticException exception) {
                        exceptionHandler(exception);
                        return;
                    }
                }
                case '/' -> result = calc.divide(num1, num2);
                case '*' -> result = calc.multiply(num1, num2);
                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
            System.out.println(result);
        } catch (StringIndexOutOfBoundsException exception) {
            exceptionHandler(exception);
        } catch (IllegalStateException e) {
            exceptionHandler(e);
        }

    }

    private static void exceptionHandler(Exception e) {
        e.printStackTrace();
        System.err.println("Kivétel kezelve!");
    }

}
