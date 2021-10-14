package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        out(UserValidator.isValidUserName(scanner.nextLine()));
        System.out.println("Password 2X: ");
        out(UserValidator.isValidPassword(scanner.nextLine(),scanner.nextLine()));
        System.out.println("email: ");
        out(UserValidator.isValidEmail(scanner.nextLine()));
    }

    private static void out(boolean isValid){
        System.out.println(isValid ? "valid" : "not valid");
    }
}
