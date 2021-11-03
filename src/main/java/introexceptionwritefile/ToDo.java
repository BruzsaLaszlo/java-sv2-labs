package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {

    public static void main(String[] args) {

        List<String> todo = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem az első teendőt: ");
        String s = scanner.nextLine();
        while (!s.equalsIgnoreCase("x")) {
            todo.add(s);
            System.out.print("Kérem a következő teendőt (X vége): ");
            s = scanner.nextLine();
        }

        try {
            Files.write(Path.of("./src/main/resources/todo.txt"), todo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
