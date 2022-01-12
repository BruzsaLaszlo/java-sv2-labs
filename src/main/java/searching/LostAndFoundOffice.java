package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LostAndFoundOffice {

    private List<LostProperty> lostProperties = new ArrayList<>();

    public LostProperty findLostProperty(LostProperty lostProperty) {
        Collections.sort(lostProperties);
        int found = Collections.binarySearch(lostProperties, lostProperty);

        if (found < 0) {
            throw new IllegalArgumentException("Property not found.");
        }
        return lostProperties.get(found);
    }

    public void addProperty(LostProperty lostProperty) {
        lostProperties.add(lostProperty);
    }
}
