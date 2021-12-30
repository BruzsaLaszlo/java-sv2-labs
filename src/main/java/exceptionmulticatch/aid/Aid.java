package exceptionmulticatch.aid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Aid {

    private int amount;

    public Aid(int amount) {
        this.amount = amount;
    }

    public List<String> countAmountsOfAid(Path path) {
        var result = new ArrayList<String>();

        try {
            for (String line : Files.readAllLines(path)) {
                var data = line.split(":");
                int money = amount / Integer.parseInt(data[1].trim());
                result.add(data[0] + ": " + money);
            }
        } catch (NullPointerException
                | NumberFormatException
                | ArrayIndexOutOfBoundsException
                | ArithmeticException
                | NoSuchFileException e) {
            throw new IllegalStateException("Something went wrong while counting.", e);
        } catch (IOException e) {
            throw new IllegalStateException("IOException", e);
        }

        return result;
    }

}
