package methodoverloading;

import java.util.List;

public class ClassFiveA {

    private final List<String> names = List.of(
            "Pisti","Zoli","Ildi","Kiss József","Ica","Jani","Geri","Csabi","Anna","Ida","Dorka");

    public String getTodayReferringStudent(int number) {
        return names.get(number);
    }

    public String getTodayReferringStudent(Number number) {
        return names.get(number.getValue());
    }

    public String getTodayReferringStudent(String numberName) {
        return names.get(Number.valueOf(numberName.toUpperCase()).getValue());
    }

}
