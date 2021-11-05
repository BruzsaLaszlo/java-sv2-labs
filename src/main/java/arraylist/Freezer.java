package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Freezer {

    public static void main(String[] args) {

        List<String> etel = new ArrayList<>();
        etel.add("csirke mell");
        etel.add("pacal");
        etel.add("hal");
        etel.add("máj");
        etel.add("bab");

        System.out.println(etel);
        System.out.println("Méret : " + etel.size());

    }

}
