package collectionsmap;

import java.util.Map;

public class Casting {

    public String callNextApplicant(int lastNumber, Map<Integer, String> applicants) {
        int closest = 1_000;
        Map.Entry<Integer, String> found = null;
        for (Map.Entry<Integer, String> entry : applicants.entrySet()) {
            int diff = entry.getKey() - lastNumber;
            if (diff > 0 && diff < closest) {
                closest = diff;
                found = entry;
            }
        }
        return found.getValue();
    }

}
