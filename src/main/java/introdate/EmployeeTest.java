package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {

        int year;
        int month;
        int day;
        String name;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a nevet: ");
        name = scanner.nextLine();
        System.out.println("Születési év: ");
        year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Születési hónap: ");
        month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Születési nap: ");
        day = scanner.nextInt();

        Employee employee = new Employee(year, month, day, name);

        System.out.println("név: " + name);
        System.out.println("születési dátum: " + employee.getDateOfBirth());
        System.out.println("a munkavállalás kezdete: " + employee.getBeginEmployment());
    }
}
