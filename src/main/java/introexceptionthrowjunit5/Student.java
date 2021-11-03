package introexceptionthrowjunit5;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Integer> notes = new ArrayList<>();

    public void addNotes(int note) {
        if (note > 5 || note < 1)
            throw new IllegalArgumentException("Note must be between 1 and 5!");
    }

}
