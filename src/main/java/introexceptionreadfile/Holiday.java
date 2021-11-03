package introexceptionreadfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Holiday {

    public static void main(String[] args) {

        String path = "./src/main/java/introexceptionreadfile/holiday.txt";
        try {
            List<String> list =  Files.readAllLines(Path.of(path));
            System.out.println(list);
        }catch (IOException exception){
            System.out.println("cant read file");
            exception.printStackTrace();
        }

    }
}
