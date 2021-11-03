package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Birthday {

    public static void main(String[] args) {

        List<String> todo = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            System.out.print("Kérem az " + i + ". nevet (X kilépés): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("x"))
                break;
            System.out.print("Kérem a születési dátumot: ");
            String birthday = scanner.nextLine();
            todo.add(name + ";" + birthday);
        }

        try {
            Files.write(Path.of("./src/main/resources/birthdays.csv"), todo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
