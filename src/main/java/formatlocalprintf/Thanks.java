package formatlocalprintf;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Thanks {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peti", "Csabi", "Ildi", "Andi", "Zoli");
        for (String name : names)
            System.out.printf(
                    new Locale("hu", "HU"),
                    "Kedves %s! Örülünk, hogy termékünket választotta!%n",
                    name);

    }

}
