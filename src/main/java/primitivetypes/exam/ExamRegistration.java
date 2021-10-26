package primitivetypes.exam;

import java.time.LocalDate;
import java.util.Scanner;

public class ExamRegistration {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String birth = scanner.nextLine();
        String zip = scanner.nextLine();
        String average = scanner.nextLine();

        Person person = new Person(name, LocalDate.parse(birth), Integer.valueOf(zip), Double.valueOf(average));

        Exam exam = new Exam();
        exam.addPerson(person);

    }
}
