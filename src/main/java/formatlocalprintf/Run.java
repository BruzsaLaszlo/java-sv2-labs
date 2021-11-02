package formatlocalprintf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Run {

    private List<Double> runs;
    private String name;

    public Run(String name) {
        this.runs = new ArrayList<>();
        this.name = name;
    }

    public void addRun(double km) {
        runs.add(km);
    }

    public String printFormattedRun() {
        double sum = 0;
        for (Double d : runs)
            sum += d;
        return String.format(
                new Locale("hu", "HU"),
                "Kedves %s! A mai dátum: %2$ty-%2$tm-%2$td. Ezen a héten ez a(z) 4. futásod. Most %3$.1f km-t futottál. Csak így tovább!",
                name,
                LocalDate.now(),
                sum);
    }

    public static void main(String[] args) {

        Run run = new Run("Pistike");
        run.addRun(1.43);
        run.addRun(1.36);
        run.addRun(2.57);
        run.addRun(11.81);
        System.out.println(run.printFormattedRun());

    }

}
