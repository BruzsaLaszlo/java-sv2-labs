package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ClassFiveA {

    private List<String> names = new ArrayList<>();

    public String getTodayReferringStedent(int number) {
        return names.get(number);
    }

    public String getTodayReferringStedent(Number number) {
        return names.get(number.getValue());
    }

    public String getTodayReferringStedent(String numberName) {
        return names.get(Number.valueOf(numberName).getValue());
    }

}
