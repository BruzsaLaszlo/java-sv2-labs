package introexceptioncheckedtrace;

import java.io.IOException;

public class Underground {

    public static void main(String[] args) {

        Operation operation = new Operation();
        String path = "./src/main/java/introexceptioncheckedtrace/underground.txt";

        try {
            System.out.println(operation.getDailySchedule(operation.readFile(path)));
        } catch (IOException exception) {
            System.err.println("cant read file");
        }

    }

}
