package exceptionresource.siblings;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Siblings {

    public List<String> getFullNames(String lastName, Path path) {
        try (Scanner sc = new Scanner(path)) {
            var result = new ArrayList<String>();
            while (sc.hasNextLine()) {
                result.add(lastName + " " + sc.nextLine());
            }
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file");
        }
    }

}
