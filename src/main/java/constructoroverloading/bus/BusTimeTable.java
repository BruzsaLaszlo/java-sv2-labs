package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private final List<SimpleTime> departureTime;

    public BusTimeTable(List<SimpleTime> timeTable) {
        departureTime = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        this(fillTimeTable(firstHour, lastHour, everyMinute));

    }

    private static List<SimpleTime> fillTimeTable(int firstHour, int lastHour, int everyMinute) {
        List<SimpleTime> filled = new ArrayList<>();
        for (int i = firstHour; i <= lastHour; i++) {
            filled.add(new SimpleTime(i, everyMinute));
        }
        return filled;
    }

    public List<SimpleTime> getTimeTable() {
        return List.copyOf(departureTime);
    }

    public SimpleTime nextBus(SimpleTime actual) {


        for (SimpleTime st : departureTime) {
            if (st.difference(actual) >= 0) {
                return st;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

}
