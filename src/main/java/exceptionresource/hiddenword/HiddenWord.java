package exceptionresource.hiddenword;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class HiddenWord {

    public String getHiddenWord(Path path) {
        var sb = new StringBuilder();
        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine()) {
                boolean found = false;
                for (Character c : sc.nextLine().toCharArray()) {
                    if (Character.isLetter(c)) {
                        sb.append(c);
                        found = true;
                    }
                }
                if (!found) {
                    sb.append(" ");
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("can not read file!");
        }
        return sb.toString();
    }

}
