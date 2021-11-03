package introexceptionthrow;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        boolean registrationSuccess = true;

        System.out.println("Üdvözöllek a felhasználó!");

        System.out.print("Kérlek add meg a neved: ");
        String name = sc.nextLine();
        try {
            validation.validateName(name);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            registrationSuccess = false;
        }

        System.out.print("Kérlek add meg az életkorod: ");
        Integer age = null;
        try {
             age = validation.validateAge(sc.nextLine());
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            registrationSuccess = false;
        }

        if (registrationSuccess)
            System.out.println("A regisztráció sikeres volt! (" + name + " " + age);
        else
            System.out.println("A regisztráció sikertelen volt!");

    }

}
