package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    public static void main(String[] args) {

        final List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        days.set(days.indexOf("Tuesday"), "Wednesday");

        System.out.println(days);

    }

}
