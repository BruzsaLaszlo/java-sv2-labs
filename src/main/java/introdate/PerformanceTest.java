package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {

        Performance performance = new Performance(LocalDate.of(1989, 6, 2),
                "Queen",
                LocalTime.of(18, 00),
                LocalTime.of(20, 00));

        System.out.println(performance.getInfo());
    }

}
