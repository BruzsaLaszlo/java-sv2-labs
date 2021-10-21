package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        UserValidator userValidator = new UserValidator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Username: ");
        System.out.println(userValidator.isValidUserName(scanner.nextLine()) ? "valid" : "not valid");

        System.out.println("Password 2X: ");
        System.out.println(userValidator.isValidPassword(scanner.nextLine(), scanner.nextLine()) ? "valid" : "not valid");

        System.out.println("email: ");
        System.out.println(userValidator.isValidEmail(scanner.nextLine()) ? "valid" : "not valid");

    }

}
