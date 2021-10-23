package intromethods.registration;

import java.time.LocalDate;
import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        Registration registration = new Registration();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a vezetéknevet: ");
        String firstName = scanner.nextLine();
        System.out.println("Kérem a keresztnevet: ");
        String lastName = scanner.nextLine();
        String name = registration.getName(firstName, lastName);

        System.out.println("Kérem a születési évet: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kérem a születési hónapot: ");
        int moth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kérem a születési napot: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate dateOfBirth = registration.getYearOfBirth(year, moth, day);

        System.out.println("Kérem az email címet: ");
        String email = scanner.nextLine();

        Person person = new Person(name, dateOfBirth, email);
        System.out.println(person);

    }

    private String getName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    private LocalDate getYearOfBirth(int year, int moth, int day) {
        return LocalDate.of(year, moth, day);
    }

}
